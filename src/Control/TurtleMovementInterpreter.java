package Control;

import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.geometry.Point2D;
import drawableobject.DrawableObject;

/**
 * Class interprets a move command to generate a DrawableObject
 * for the active turtle e.g. for a move 50 command, the class will check 
 * the active turtle's pen-down state, thus decide whether or not to use the LineFactory, 
 * it then updates the Turtle's location 
 * @author allankiplagat, akyker20
 *
 */
public class TurtleMovementInterpreter {
    public static final String ORIGIN2D = "Origin2D"; 
    public static final String DESTINATION2D = "Destination2D";

    public static Queue<DrawableObject> move (double distance) {
        Queue<DrawableObject> queue = new LinkedList<DrawableObject>();
        //compute destination point
        Point2D computedDestination = computeDestination(distance);
        
        if (GUIState.activeTurtle.getPenDownStatus()) {
            //convert source & destination points to text for passing as DrawableObject
            HashMap<String,String> destinationMap = new HashMap<String,String>();
            
            String origin = Double.toString(GUIState.activeTurtle.getLocation().getX())+" "+
                    Double.toString(GUIState.activeTurtle.getLocation().getY());
            destinationMap.put(ORIGIN2D,origin);
            
            String destination = Double.toString(computedDestination.getX())+" "+
                    Double.toString(computedDestination.getY());
            destinationMap.put(DESTINATION2D,destination);
  
            queue.add(new DrawableObject(ComponentInitializer.GRID_DRAWER,
                                         FactoryInitializer.LINE_FACTORY,
                                         destinationMap));
        }
        //move turtle image
        GUIState.activeTurtle.setLocation(computedDestination);
        return queue;
    }

    /**
     * Method computes a turtle & line's destination Point2D based on the active
     * turtle's location, heading and distance to move
     * @return
     */
    private static Point2D computeDestination(double distance ) {
        double x = GUIState.activeTurtle.getLocation().getX()+
                Math.sin( Math.toRadians(GUIState.activeTurtle.getHeading()) )*distance;
        
        double y = GUIState.activeTurtle.getLocation().getY()-
                Math.cos( Math.toRadians(GUIState.activeTurtle.getHeading()) )*distance;
        
        Point2D destination = new Point2D(x,y);
        return destination;
    }

}
