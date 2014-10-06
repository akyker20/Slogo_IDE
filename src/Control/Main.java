package Control;


import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
        
        DrawableObject turtle = new DrawableObject(ComponentInitializer.GRID_DRAWER,
                                   FactoryInitializer.TURTLE_FACTORY,
                                   new HashMap<String, String>());
        //place turtle first
        q.add(turtle);
        control.drawDrawableObjects(q);
        
        //do series of movements
        GUIState.activeTurtle.setPenDownStatus(true);
        GUIState.activeTurtle.setHeading(180);
        control.drawDrawableObjects(TurtleMovementInterpreter.move(100));
        
        GUIState.activeTurtle.setPenDownStatus(false);
        GUIState.activeTurtle.setHeading(270);
        control.drawDrawableObjects(TurtleMovementInterpreter.move(100));
        
        GUIState.activeTurtle.setPenDownStatus(true);
        GUIState.activeTurtle.setHeading(360);
        control.drawDrawableObjects(TurtleMovementInterpreter.move(100));
        
        GUIState.activeTurtle.setHeading(90);
        control.drawDrawableObjects(TurtleMovementInterpreter.move(50));
        
        GUIState.activeTurtle.setHeading(0);
        control.drawDrawableObjects(TurtleMovementInterpreter.move(25));
        
    }

}
