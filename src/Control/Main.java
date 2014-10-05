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
        DrawableObject object =

                new DrawableObject(ComponentInitializer.GRID_DRAWER,
                                   FactoryInitializer.LINE_FACTORY, "name???",
                                   new HashMap<String, String>());
        DrawableObject object2 =
                new DrawableObject(ComponentInitializer.GRID_DRAWER,
                                   FactoryInitializer.TURTLE_FACTORY, ".....",
                                   new HashMap<String, String>());


        q.add(object);
        q.add(object2);
        control.drawDrawableObjects(q);

    }

}
