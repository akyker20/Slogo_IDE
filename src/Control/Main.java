package Control;

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
        DrawableObject object =
                new DrawableObject("GridDrawer", "LineFactory", "name???",
                                   new HashMap<String, String>());
        q.add(object);
        control.drawDrawableObjects(q);
    }

}
