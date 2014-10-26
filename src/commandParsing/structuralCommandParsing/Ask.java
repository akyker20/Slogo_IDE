package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class Ask extends StructuralCommand {

	public Ask(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		List<Turtle> savedListOfTurtles = workspace.turtles.getActiveTurtles();
		workspace.turtles.clearActiveTurtles();
		List<Integer> turtleIDList = new ArrayList<Integer>();
		double lastTurtleID = 0;
		// getTurtleIDsBetweenBraces
		for (Integer i : turtleIDList) {
			workspace.turtles.activateTurtle(workspace.turtles.getTurtleWithID(i));
			lastTurtleID = i;
		}
		// Extract command between braces
		// Run commands
		// Return result of last command on last active turtle
		workspace.turtles.clearActiveTurtles();
		for (Turtle t : savedListOfTurtles) {
			workspace.turtles.activateTurtle(t);
		}
		return lastTurtleID;
	}

}
