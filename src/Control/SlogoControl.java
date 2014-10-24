package Control;

import gui.mainclasses.GUIController;
import gui.variableslist.WorkspaceVariable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import translator.Translator;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.NullCommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;


/**
 * Class sets up the control that separates the front-end and the back-end
 * The class implements both SlogoGraphics and SlogoBackend interfaces and delivers
 * an instance of itself to the GUIController and BackEndController
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */

public class SlogoControl implements SlogoGraphics, SlogoBackend {

    private GUIController myGUI;
    Translator translator;
    WorkspaceState workspace;

    /**
     * Initializes the GUIController and BackEndController,
     * providing a SlogoGraphics instance of itself to the front-end
     * and a SlogoBackEnd instance of itself to the back-end
     *
     * @param stage
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */

    public SlogoControl (Stage stage) throws IOException, ParserConfigurationException, SAXException {
        Map<String,WorkspaceVariable> variableMap = new HashMap<String,WorkspaceVariable>();
        myGUI = new GUIController(stage, this);
        translator = new Translator("english");
        workspace = new WorkspaceState(new Turtle(),variableMap, translator);
        parseCommandString("home");
    }

    @Override
    public Queue<DrawableObject> parseCommandString (String command) {
        Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();


        Iterator<String> translatedCommands = translator.translate(command);

        while(translatedCommands.hasNext()){
            CommandParser parser = new NullCommandParser(workspace);
            try {
                parser = CommandParser.createParser(translatedCommands.next(), workspace);
            }
            catch (CompileTimeParsingException e) {
                objectQueue.clear();
                objectQueue.add(e.generateErrorMessage());
            }
            try {
                parser.parse(translatedCommands, objectQueue);
                myGUI.addPreviousCommand(command);
            }
            catch (CompileTimeParsingException | RunTimeDivideByZeroException
                    | RunTimeNullPointerException e) {
                objectQueue.clear();
                objectQueue.add(e.generateErrorMessage());
            }
        }
        System.out.println(objectQueue.size());
        drawDrawableObjects(objectQueue);
        return objectQueue;
    }

    @Override
    public void drawDrawableObjects (Queue<DrawableObject> objects) {
        myGUI.drawDrawableObjects(objects);
    }

    @Override
    public DrawableObject setVariable (String name, int value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveCommandsToFunction (String commands) {
        // TODO Auto-generated method stub
    }
}
