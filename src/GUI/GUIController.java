package GUI;

import java.util.Queue;
import drawableobject.DrawableObject;
import Control.SlogoGraphics;
import Feature.Feature;
import Feature.FeatureInitializer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIController {
    
    private DrawableObjectParser myParser;
    private ComponentDrawer[] myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private BorderPane myPane;
    
    public GUIController(Stage stage, SlogoGraphics control){
        myPane = StageInitializer.init(stage);
        myComponentDrawers = ComponentInitializer.init(myPane);
        myObjectFactories = FactoryInitializer.init();
        FeatureInitializer.init(myComponentDrawers, control);
        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);
    }

    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while(!objectQueue.isEmpty()){
            myParser.parseDrawableObject(objectQueue.poll());
        }
        
    }
}
