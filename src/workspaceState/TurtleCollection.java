package workspaceState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import commandParsing.exceptions.RunTimeNullPointerException;


/**
 * This class contains all of the turtles, all of the active turtles, and all of the stamps.
 * 
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */


public class TurtleCollection {
    private Map<Integer, Turtle> turtles = new HashMap<Integer, Turtle>();
    private Map<Integer, Turtle> activeTurtles = new HashMap<Integer, Turtle>();
    private Map<Integer, Turtle> turtleStamps = new HashMap<Integer, Turtle>();
    private int IDCounter = 1;
    private int lastAddedID = 1;

    public void addTurtle () throws RunTimeNullPointerException {
        generateValidTurtleID();
        addTurtle(IDCounter);
        IDCounter++;
    }

    public void addTurtle (int ID) throws RunTimeNullPointerException {
        Turtle newTurtle = new Turtle(ID);
        turtles.put(ID, newTurtle);
        activateTurtle(ID);
        lastAddedID = ID;
    }

    protected void generateValidTurtleID () {
        while (turtles.containsKey(IDCounter)) {
            IDCounter++;
        }
    }

    public void activateTurtle (int ID) throws RunTimeNullPointerException {
        if (!turtles.containsKey(ID)) { throw new RunTimeNullPointerException("Turtle with ID: " +
                ID
                +
                "cannot be activated as it does not exist."); }
        activeTurtles.put(ID, turtles.get(ID));
    }

    public void clearActiveTurtles () {
        activeTurtles.clear();
    }

    public List<Turtle> getActiveTurtles () {
        return new ArrayList<Turtle>(activeTurtles.values());
    }

    public List<Turtle> getAllTurtles () {
        return new ArrayList<Turtle>(turtles.values());
    }

    public Turtle getLastActiveTurtle () {
        Turtle lastTurtle = new Turtle(-1);
        for (Turtle t : activeTurtles.values()) {
            if (t.getID() > lastTurtle.getID()) {
                lastTurtle = t;
            }
        }
        return lastTurtle;
    }

    public void addStamp (Turtle stamp) {
        turtleStamps.put(stamp.getID(), stamp);
    }

    public List<Turtle> getStamps () {
        return new ArrayList<Turtle>(turtleStamps.values());
    }

    public void removeAllStamps () {
        turtleStamps.clear();
    }

    public Turtle getTurtleWithID (Integer ID) {
        return turtles.get(ID);
    }

    public boolean hasTurtleWithID (Integer ID) {
        return turtles.containsKey(ID);
    }

    public Turtle getLastAddedTurtle () {
        return turtles.get(lastAddedID);
    }

}
