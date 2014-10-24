package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;


public class If extends StructuralCommandOnBooleanSwitch {
	
	public If(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		
		accumulateComponents(commandString,1,objectQueue);
		evaluateBooleanExpression();
		
		if(booleanSwitch){
			extractCommandsBetweenBraces(commandString);
		}
		else {
			ignoreUntilClosingBrace(commandString);
			setEnclosedCommandsToEmptyList();
		}
		
		parseCommandsBetweenBraces(enclosedCommands.iterator(), objectQueue);
		
		return returnValue;
	}

}
