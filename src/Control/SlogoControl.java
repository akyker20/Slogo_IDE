package Control;

import gui.mainclasses.GUIController;
import java.util.Queue;
import javafx.stage.Stage;
import drawableobject.DrawableObject;


public class SlogoControl implements SlogoGraphics, SlogoBackend {

    private GUIController myGUI;

    public SlogoControl (Stage stage) {
        myGUI = new GUIController(stage, this);
    }

    @Override
    public Queue<DrawableObject> parseCommandString (String command) {
        System.out.println(command);
        return null;
    }

    @Override
    public void drawDrawableObjects (Queue<DrawableObject> objects) {
        myGUI.drawDrawableObjects(objects);
    }

}
