package GUI;

import java.util.Queue;
import drawableobject.DrawableObject;
import Control.SlogoGraphics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIController {
    
    private DrawableObjectParser myParser;
    private ComponentDrawer[] myDrawers;
    
    public GUIController(Stage stage, SlogoGraphics control){
        myDrawers = GUIInitializer.init(stage, control);
        myParser = new DrawableObjectParser();
    }

    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while(!objectQueue.isEmpty()){
            myParser.parseDrawableObject(objectQueue.poll(), myDrawers);
        }
        
    }
}
