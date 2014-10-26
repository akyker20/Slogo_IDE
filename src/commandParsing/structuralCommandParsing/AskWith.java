package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;

import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class AskWith extends MultipleTurtleCommand {

	public AskWith(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {

		saveCurrentActiveTurtles();
		workspace.turtles.clearActiveTurtles();
		
		extractCommandsBetweenBraces(commandStringIterator);
		for(Turtle t : workspace.turtles.getAllTurtles()){
			determineIfTurtleIsValidRecipient(t, enclosedCommands.iterator(), objectQueue);
		}
		makeAndActivateGivenTurtles(objectQueue);
		
		extractCommandsBetweenBraces(commandStringIterator);
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
		
		workspace.turtles.clearActiveTurtles();
		restoreActiveTurtles();
		
		return returnValue;

	}

	private void determineIfTurtleIsValidRecipient(Turtle t, Iterator<String> commandIterator, Queue<DrawableObject> objectQueue) throws SLOGOException {
		workspace.turtles.clearActiveTurtles();
		workspace.turtles.activateTurtle(t.getID());
		String stringOfInterest = commandIterator.next();
		CommandParser parser = (CommandParser) createParser(stringOfInterest, workspace);
		double value = parser.parse(commandIterator, objectQueue);
		if(value!=0){
			activeTurtleIDList.add(t.getID());
		}
		workspace.turtles.clearActiveTurtles();
	}

}
