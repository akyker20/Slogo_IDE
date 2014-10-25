package gui.mainclasses;

import gui.mainclasses.workspace.WorkspaceManager;
import gui.menus.MainMenuInitializer;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Control.SlogoGraphics;
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
     * 
     * @param stage
     * @param control
     */
    public GUIController (Stage stage, SlogoGraphics control)   {
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(stage);
        myWorkspaceManager = new WorkspaceManager(control);               
        myPane.setTop(MainMenuInitializer.init(myWorkspaceManager));
        myPane.setCenter(myWorkspaceManager);
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
