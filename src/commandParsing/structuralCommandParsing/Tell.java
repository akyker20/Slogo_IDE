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

public class Tell extends StructuralCommand {
	
	List<Integer> turtleIDList = new ArrayList<Integer>();

	public Tell(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}
	
	@Override
	protected void parseCommandsBetweenBraces(Iterator<String> commands, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		double value = 0;
		while (commands.hasNext()) {
			String stringOfInterest = commands.next();
			CommandParser parser = (CommandParser) createParser(stringOfInterest, workspace);
			value = parser.parse(commands, objectQueue);
			turtleIDList.add((int) value);
		}
		returnValue = value;
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		
		workspace.turtles.clearActiveTurtles();
		double lastTurtleID = 0;
		extractCommandsBetweenBraces(commandStringIterator);
		parseCommandsBetweenBraces(commandStringIterator, objectQueue);
		
		for (Integer i: turtleIDList){
			if(workspace.turtles.hasTurtleWithID(i)){
				workspace.turtles.activateTurtle(workspace.turtles.getTurtleWithID(i));
			}
			else{
				workspace.turtles.addTurtle(new Turtle(i));
			}
			lastTurtleID = i;
		}
		
		return lastTurtleID;
	}

}
