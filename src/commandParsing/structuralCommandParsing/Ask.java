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
		extractCommandsBetweenBraces(commandStringIterator);

		for (String s : enclosedCommands) {
			turtleIDList.add(Integer.parseInt(s));
		}
		for (Integer i : turtleIDList) {
			if (workspace.turtles.hasTurtleWithID(i)) {
				workspace.turtles.activateTurtle(workspace.turtles.getTurtleWithID(i));
			}
			else {
				workspace.turtles.addTurtle(new Turtle(i));
			}
		}
		ignoreUntilClosingBrace(commandStringIterator);
		extractCommandsBetweenBraces(commandStringIterator);
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);

		workspace.turtles.clearActiveTurtles();
		for (Turtle t : savedListOfTurtles) {
			workspace.turtles.activateTurtle(t);
		}
		return returnValue;

	}

}
