package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class IfElse extends StructuralCommandOnBooleanSwitch {
	
	public IfElse(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString,	Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,	RunTimeDivideByZeroException, RunTimeNullPointerException {

		accumulateComponents(commandString,1,objectQueue);
		evaluateBooleanExpression();
		
		if(booleanSwitch){
			extractCommandsBetweenBraces(commandString);
			ignoreUntilClosingBrace(commandString);
		}
		else {
			ignoreUntilClosingBrace(commandString);
			extractCommandsBetweenBraces(commandString);
		}
		
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
		
		return returnValue;
	}

}
