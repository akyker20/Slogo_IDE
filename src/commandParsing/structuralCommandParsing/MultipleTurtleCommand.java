package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public abstract class MultipleTurtleCommand extends StructuralCommand implements TurtleGenerator {
	
	List<Turtle> savedListOfTurtles = new ArrayList<Turtle>();
	List<Integer> activeTurtleIDList = new ArrayList<Integer>();
	
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
	
	protected int makeAndActivateGivenTurtles(Queue<DrawableObject> objectQueue) throws RunTimeNullPointerException {
		int lastTurtleID = 0;
		for (int i : activeTurtleIDList) {
			if (workspace.turtles.hasTurtleWithID(i)) {
				workspace.turtles.activateTurtle(i);
			}
			else {
				workspace.turtles.addTurtle(i);
				Turtle newTurtle = workspace.turtles.getLastAddedTurtle();
				objectQueue.add(generateDrawableObjectRepresentingTurtle(newTurtle));
			}
			lastTurtleID = i;			
		}
		return lastTurtleID;
	}
	
	protected void saveCurrentActiveTurtles() {
		savedListOfTurtles.addAll(workspace.turtles.getActiveTurtles());
	}
	
	protected void restoreActiveTurtles() throws RunTimeNullPointerException {
		for (Turtle t : savedListOfTurtles) {
			workspace.turtles.activateTurtle(t.getID());
		}
	}

}
