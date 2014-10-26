package workspaceState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurtleCollection {
	private List<Turtle> turtles = new ArrayList<Turtle>();
	private List<Turtle> activeTurtles  = new ArrayList<Turtle>();
	private Map<Integer, Turtle> IDtoTurtleMap = new HashMap<Integer, Turtle>();
	private int IDCounter = 1;
	
	public void addTurtle(Turtle someTurtle) {
		turtles.add(someTurtle);
		while (IDtoTurtleMap.containsKey(IDCounter)){
			IDCounter++;
		}
		someTurtle.setID(IDCounter);
		IDtoTurtleMap.put(IDCounter, someTurtle);
		activateTurtle(someTurtle);
		IDCounter++;
	}

	public void activateTurtle(Turtle someTurtle) {
		activeTurtles.add(someTurtle);
	}

	public void clearActiveTurtles() {
		activeTurtles.clear();
	}

	public List<Turtle> getActiveTurtles() {
		return activeTurtles;
	}

	public Turtle getLastActiveTurtle() {
		return activeTurtles.get(activeTurtles.size() - 1);
	}
	
	public Turtle getTurtleWithID(Integer ID){
		return IDtoTurtleMap.get(ID);
	}
	
	public boolean hasTurtleWithID(Integer ID){
		return IDtoTurtleMap.containsKey(ID);
	}
}
