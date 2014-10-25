package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class AskWith extends StructuralCommand {

	public AskWith(WorkspaceState someWorkspace) {
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
		
		// For all turtles
		// Evaluate BooleanExpression
		// If true execute commandbetweenbraces
		// Return result of last command run
		
		return 0;
	}

}
