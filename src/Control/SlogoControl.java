package Control;

import gui.mainclasses.GUIController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import javafx.stage.Stage;
import state.State;
import state.Turtle;
import translator.Translator;
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


    /**
     * Initializes the GUIController and BackEndController,
     * providing a SlogoGraphics instance of itself to the front-end
     * and a SlogoBackEnd instance of itself to the back-end
     *
     * @param stage
     */

    public SlogoControl (Stage stage) {
        myGUI = new GUIController(stage, this);
    }

    @Override
    public Queue<DrawableObject> parseCommandString (String command) throws IOException, CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
        Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();
        State state = new State(new Turtle(), new HashMap<String, Double>());
        Translator translator = new Translator("english");
        Iterator<String> translatedCommands = translator.translate(command);
        CommandParser parser = CommandParser.createParser(translatedCommands.next(), state);
        parser.parse(translatedCommands, objectQueue);
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

    @Override
    public DrawableObject saveCommand (String command) {
        System.out.println("Saving: " + command);
        return null;
    }

}
