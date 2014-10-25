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
		
//		accumulateComponents(commandStringIterator, 1, objectQueue);
//		evaluateBooleanExpression();
//
//		if (booleanSwitch) {
//			extractCommandsBetweenBraces(commandStringIterator);
//		} else {
//			ignoreUntilClosingBrace(commandStringIterator);
//			setEnclosedCommandsToEmptyList();
//		}
//
//		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
//
//		return returnValue;
		
//		double amountToRotate = 0;
//		for (Turtle t : workspace.turtles.getActiveTurtles()) {
//			amountToRotate = components.get(0) - t.getHeading();
//			t.rotate(amountToRotate);
//			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
//		}
//		return Math.abs(amountToRotate);
		workspace.turtles.clearActiveTurtles();
		List<Integer> turtleIDList = new ArrayList<Integer>();
		double lastTurtleID =0;
//		getTurtleIDsBetweenBraces
		for (Integer i: turtleIDList){
			workspace.turtles.activateTurtle(workspace.turtles.getTurtleWithID(i));
			lastTurtleID = i;
		}
		
		return lastTurtleID;
	}

}
