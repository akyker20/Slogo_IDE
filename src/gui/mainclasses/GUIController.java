package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.features.Feature;
import gui.features.FeatureInitializer;
import java.util.Queue;
import drawableobject.DrawableObject;
import Control.SlogoGraphics;
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
