package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;

import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class Tell extends MultipleTurtleCommand {
	

	public Tell(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}
	
	

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		
		workspace.turtles.clearActiveTurtles();
		double lastTurtleID = 0;
		extractCommandsBetweenBraces(commandStringIterator);
		determineTurtlesToActivate(commandStringIterator, objectQueue);
		
		makeAndActivateGivenTurtles(objectQueue);
		
		return lastTurtleID;
	}

}
