package Control;

import gui.turtle.Turtle;
import java.util.HashMap;
import java.util.Map;


public class GUIState {
    public static int activeTurtle;
    public static Map<Integer, Turtle> turtleMap = new HashMap<Integer, Turtle>();

    public static void addTurtle (int turtleID, Turtle turtle) {
        turtleMap.put(turtleID, turtle);
    }

    public Turtle getTurtle (int turtleID) {
        return turtleMap.get(turtleID);
    }
}
