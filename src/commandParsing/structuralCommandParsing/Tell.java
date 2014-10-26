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

	public Tell(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		
		workspace.turtles.clearActiveTurtles();
		List<Integer> turtleIDList = new ArrayList<Integer>();
		double lastTurtleID = 0;
		extractCommandsBetweenBraces(commandStringIterator);
		
		for (String s: enclosedCommands){
			turtleIDList.add(Integer.parseInt(s));
		}
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
