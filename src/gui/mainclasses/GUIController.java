package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.TurtleFactory;
import gui.variableslist.WorkspaceVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
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

    private DrawableObjectParser myParser;
    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private BorderPane myPane;
    public static ResourceBundle GUI_TEXT;
    public static Stage GUI_STAGE;
    public static Map<String,WorkspaceVariable> GUI_WORKSPACE_VARIABLE_MAP;


    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     */

    public GUIController (Stage stage, SlogoGraphics control,HashMap<String,WorkspaceVariable> variables) {
        GUI_WORKSPACE_VARIABLE_MAP = variables;
        GUI_STAGE = stage;
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(GUI_STAGE);
        myComponentDrawers = ComponentInitializer.init(myPane);
        myObjectFactories = FactoryInitializer.init();
        FeatureInitializer.init(myComponentDrawers, control);
        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     *
     * @param objectQueue
     */
    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while (!objectQueue.isEmpty()) {
            myParser.parseDrawableObject(objectQueue.poll());
        }

    }
}
