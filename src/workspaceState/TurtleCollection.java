package workspaceState;

import java.util.ArrayList;
import java.util.List;

public class TurtleCollection {
	private List<Turtle> turtles = new ArrayList<Turtle>();
	private List<Turtle> activeTurtles  = new ArrayList<Turtle>();
	
	public void addTurtle(Turtle someTurtle) {
		turtles.add(someTurtle);
		activateTurtle(someTurtle);
	}

	public void activateTurtle(Turtle someTurtle) {
		activeTurtles.add(someTurtle);
	}
	
	public void clearActiveTurtles(){
		activeTurtles.clear();
	}
	
	public List<Turtle> getActiveTurtles(){
		return activeTurtles;
	}
	
	public Turtle getLastActiveTurtle(){
		return activeTurtles.get(activeTurtles.size()-1);
	}
}
