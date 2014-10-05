package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.features.FeatureInitializer;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Control.SlogoGraphics;
import drawableobject.DrawableObject;


public class GUIController {

    private DrawableObjectParser myParser;
    private ComponentDrawer[] myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private BorderPane myPane;
    public static ResourceBundle GUI_TEXT;

    public GUIController (Stage stage, SlogoGraphics control) {
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(stage);
        myComponentDrawers = ComponentInitializer.init(myPane);
        myObjectFactories = FactoryInitializer.init();
        FeatureInitializer.init(myComponentDrawers, control);
        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);
    }

    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while (!objectQueue.isEmpty()) {
            myParser.parseDrawableObject(objectQueue.poll());
        }

    }
}
