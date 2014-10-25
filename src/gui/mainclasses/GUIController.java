package gui.mainclasses;

import gui.commandlist.WorkspaceCommand;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.significantcommands.tabs.SavedCommandsTab;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.nodes.TurtleNodes;
import gui.mainclasses.workspace.Workspace;
import gui.mainclasses.workspace.WorkspaceManager;
import gui.menus.MainMenuInitializer;
import gui.variableslist.WorkspaceVariable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
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
    public static WorkspaceManager myWorkspaceManager;

    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */

    public GUIController (Stage stage, SlogoGraphics control) throws ParserConfigurationException, SAXException, IOException {
        GUI_TEXT = LocaleInitializer.init();

        myPane = StageInitializer.init(stage, control);
        myWorkspaceManager = new WorkspaceManager(this,control);               
        myPane.setTop(MainMenuInitializer.init());
        myPane.setCenter(myWorkspaceManager.getTabPane());

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

    public void clearCurrentWorkspace () {
        myWorkspaceManager.getActiveWorkspace().clearCurrentWorkspace();
    }

    public void addPreviousCommand (String command) {
        myWorkspaceManager.getActiveWorkspace().addPreviousCommand(command);    
    }
}
