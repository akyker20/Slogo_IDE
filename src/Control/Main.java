package Control;


import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javafx.application.Application;
import javafx.stage.Stage;
import drawableobject.DrawableObject;


public class Main extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        SlogoControl control = new SlogoControl(stage);

        Queue<DrawableObject> q = new LinkedList<DrawableObject>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("origin", "50 50");
        map.put("destination", "100 120");
        q.add(new DrawableObject("GridDrawer", "LineFactory", map));
        control.drawDrawableObjects(q);
        
    }

}
