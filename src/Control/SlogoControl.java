package Control;

import gui.mainclasses.GUIController;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.NullCommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.LanguageFileNotFoundException;
import commandParsing.exceptions.PropertyFileAccessException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;


/**
 * Class sets up the control that separates the front-end and the back-end The
 * class implements both SlogoGraphics and SlogoBackend interfaces and delivers
 * an instance of itself to the GUIController and BackEndController
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */

public class SlogoControl implements SlogoGraphics, SlogoBackend {

    public static final String NEW_TURTLE_COMMAND = "mk";

    private GUIController myGUI;
    private WorkspaceState activeState;
    private Map<Integer, WorkspaceState> myWorkspaceStates;

    /**
     * Initializes the GUIController and BackEndController, providing a
     * SlogoGraphics instance of itself to the front-end and a SlogoBackEnd
     * instance of itself to the back-end
     *
     * @param stage
     * @throws RunTimeNullPointerException
     * @throws RunTimeDivideByZeroException
     * @throws CompileTimeParsingException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */

    public SlogoControl (Stage stage) {
        myWorkspaceStates = new HashMap<Integer, WorkspaceState>();
        myGUI = new GUIController(stage, this);
        parseCommandString(NEW_TURTLE_COMMAND);
    }

    @Override
    public void createWorkspaceState (int workspaceID) {
        try {
            activeState = new WorkspaceState();
            myWorkspaceStates.put(workspaceID, activeState);
        }
        catch (LanguageFileNotFoundException | PropertyFileAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void setActiveWorkspaceState (int workspaceID) {
        activeState = myWorkspaceStates.get(workspaceID);
    }

    @Override
    public Queue<DrawableObject> parseCommandString (String command) {
        Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();

        command = sanitize(command);

        Iterator<String> translatedCommands = activeState.translator.translate(command);
        while (translatedCommands.hasNext()) {
            CommandParser parser = new NullCommandParser(activeState);
            try {
                parser = CommandParser.createParser(translatedCommands.next(), activeState);
            }
            catch (CompileTimeParsingException e) {
                objectQueue.clear();
                objectQueue.add(e.generateErrorMessage());
            }
            try {
                parser.parse(translatedCommands, objectQueue);
            }
            catch (SLOGOException e) {
                objectQueue.clear();
                objectQueue.add(e.generateErrorMessage());
            }
        }
        myGUI.getWorkspaceManager().getActiveWorkspace().addPreviousCommand(command);

        drawDrawableObjects(objectQueue);
        return objectQueue;
    }

    private String sanitize (String command) {
        return Arrays.asList(command.split(" ")).stream()
                .filter(s -> s.length() > 0)
                .collect(Collectors.joining(" "));
    }

    @Override
    public void drawDrawableObjects (Queue<DrawableObject> objects) {
        myGUI.drawDrawableObjects(objects);
    }
}
