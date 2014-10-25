package gui.mainclasses;

import gui.mainclasses.workspace.WorkspaceManager;
import gui.menus.MainMenuInitializer;
import java.io.IOException;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Control.SlogoGraphics;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;


/**
 * Class controls the GUI: initializes the scene and sets up the component
 * drawers, object factories, and features; depends on a SlogoGraphics control object
 *
 * @author allankiplagat, akyker20
 *
 */
public class GUIController {

    private BorderPane myPane;
    public static ResourceBundle GUI_TEXT;
    private WorkspaceManager myWorkspaceManager;

    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws RunTimeNullPointerException 
     * @throws RunTimeDivideByZeroException 
     * @throws CompileTimeParsingException 
     */

    public GUIController (Stage stage, SlogoGraphics control)   {
        GUI_TEXT = LocaleInitializer.init();

        myPane = StageInitializer.init(stage);
        myWorkspaceManager = new WorkspaceManager(this,control);               
        myPane.setTop(MainMenuInitializer.init(myWorkspaceManager));
        myPane.setCenter(myWorkspaceManager.getTabPane());
        myPane.setOnKeyReleased(event->moveActiveTurtlesInActiveWorkspace(event));

    }

    private void moveActiveTurtlesInActiveWorkspace (KeyEvent event) {
        myWorkspaceManager.getActiveWorkspace().moveActiveTurtles(event);
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     * @param objectQueue
     */
    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while (!objectQueue.isEmpty()) {
            myWorkspaceManager.getActiveWorkspace().parseDrawableObject(objectQueue.poll());
        }
    }
    
    public WorkspaceManager getWorkspaceManager(){
        return myWorkspaceManager;
    }
}
