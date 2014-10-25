package workspaceState;

import java.util.ArrayList;
import java.util.List;

public class TurtleCollection {
	private List<Turtle> turtles = new ArrayList<Turtle>();
	private List<Turtle> activeTurtles  = new ArrayList<Turtle>();
	private List<Turtle> turtleStamps = new ArrayList<Turtle>();
	private int IDCounter = 0;
	
	public void addTurtle(Turtle someTurtle) {
		turtles.add(someTurtle);
		someTurtle.setID(IDCounter);
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
	
	public void addStamp(Turtle stamp){
		turtleStamps.add(stamp);
	}
	
	public List<Turtle> getStamps(){
		return turtleStamps;
	}
	
	public void removeAllStamps(){
		turtleStamps.clear();
	}
}
