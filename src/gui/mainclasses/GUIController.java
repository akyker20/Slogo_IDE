package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.variableslist.WorkspaceVariable;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     */

    public GUIController (Stage stage, SlogoGraphics control) {
        GUI_STAGE = stage;
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(GUI_STAGE);
        myComponentDrawers = ComponentInitializer.init(myPane);
        
        final ObservableList<WorkspaceVariable> variablesList = FXCollections.observableArrayList();
        myObjectFactories = FactoryInitializer.init(variablesList);
        FeatureInitializer.init(myComponentDrawers, control, variablesList);
        
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
