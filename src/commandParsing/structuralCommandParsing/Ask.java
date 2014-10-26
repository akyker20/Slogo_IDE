package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;

import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class Ask extends MultipleTurtleCommand {

	public Ask(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {

		saveCurrentActiveTurtles();
		workspace.turtles.clearActiveTurtles();
		
		extractCommandsBetweenBraces(commandStringIterator);
		determineTurtlesToActivate(enclosedCommands.iterator(), objectQueue);
		makeAndActivateGivenTurtles(objectQueue);
		
		extractCommandsBetweenBraces(commandStringIterator);
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
		
		workspace.turtles.clearActiveTurtles();
		restoreActiveTurtles();
		
		return returnValue;
	}
}
