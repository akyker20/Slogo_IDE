package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.TurtleFactory;
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


    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     */

    public GUIController (Stage stage, SlogoGraphics control) {
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(stage);
        myComponentDrawers = ComponentInitializer.init(myPane);
        myObjectFactories = FactoryInitializer.init();
        FeatureInitializer.init(myComponentDrawers, control);
        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);
        placeTurtle();
    }

    
    //not great, but works for now.
    private void placeTurtle () {
        for(int i = 0; i < myObjectFactories.length; i++){
            if(myObjectFactories[i].toString().equals(FactoryInitializer.TURTLE_FACTORY)){
                Map<String, String> initialTurtleParams = new HashMap<String, String>();
                initialTurtleParams.put(TurtleFactory.HEADING, "0.0");
                initialTurtleParams.put(TurtleFactory.LOCATION, "0.0 0.0");
                myComponentDrawers.get(TurtleFactory.PARENT)
                .drawShape(myObjectFactories[i].generateObject(initialTurtleParams));
            }
        }
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
