package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public abstract class MultipleTurtleCommand extends StructuralCommand {
	
	List<Integer> activeTurtleIDList = new ArrayList<Integer>();
	List<Turtle> savedListOfTurtles = new ArrayList<Turtle>();

	public MultipleTurtleCommand(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public abstract double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException;
	
	protected void determineTurtlesToActivate(Iterator<String> commands, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		double value = 0;
		while (commands.hasNext()) {
			String stringOfInterest = commands.next();
			CommandParser parser = (CommandParser) createParser(stringOfInterest, workspace);
			value = parser.parse(commands, objectQueue);
			activeTurtleIDList.add((int) value);
		}
		returnValue = value;
	}
	
	protected int makeAndActivateGivenTurtles() {
		int lastTurtleID = 0;
		for (Integer i : activeTurtleIDList) {
			if (workspace.turtles.hasTurtleWithID(i)) {
				workspace.turtles.activateTurtle(workspace.turtles.getTurtleWithID(i));
			}
			else {
				workspace.turtles.addTurtle(new Turtle(i));
			}
			lastTurtleID = i;			
		}
		return lastTurtleID;
	}
	
	protected List<Turtle> saveCurrentActiveTurtles() {
		List<Turtle> savedListOfTurtles = new ArrayList<Turtle>();
		savedListOfTurtles.addAll(workspace.turtles.getActiveTurtles());
		return savedListOfTurtles;
	}
	
	protected void restorePreviouslySavedActiveTurtles() {
		for (Turtle t : savedListOfTurtles) {
			workspace.turtles.activateTurtle(t);
		}
	}

}
