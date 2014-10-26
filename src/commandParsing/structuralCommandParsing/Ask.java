package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
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
		determineTurtlesToActivate(commandStringIterator, objectQueue);
		makeAndActivateGivenTurtles();
		
		extractCommandsBetweenBraces(commandStringIterator);
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
		
		workspace.turtles.clearActiveTurtles();
		restorePreviouslySavedActiveTurtles();
		
		return returnValue;

	}
	
	

	

	

}
