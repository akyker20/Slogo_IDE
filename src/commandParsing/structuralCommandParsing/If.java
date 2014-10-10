package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;


public class If extends StructuralCommandOnBooleanSwitch {
	
	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		
		accumulateComponents(commandString,1,objectQueue);
		evaluateBooleanExpression();
		checkForOpeningBrace(commandString);
		
		if(booleanSwitch){
			extractCommandsBetweenBraces(commandString);
		}
		else {
			ignoreUntilClosingBrace(commandString);
			setEnclosedCommandsToEmptyList();
		}
		
		parseCommandsBetweenBraces(enclosedCommands, objectQueue);
		
		return returnValue;
	}

}
