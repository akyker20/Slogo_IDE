package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class IfElse extends StructuralCommandOnBooleanSwitch {
	
	@Override
	public double parse(Iterator<String> commandString,	Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,	RunTimeDivideByZeroException, RunTimeNullPointerException {

		accumulateComponents(commandString,1,objectQueue);
		evaluateBooleanExpression();
		checkForOpeningBrace(commandString);
		
		if(booleanSwitch){
			extractCommandsBetweenBraces(commandString);
			ignoreUntilClosingBrace(commandString);
		}
		else {
			ignoreUntilClosingBrace(commandString);
			extractCommandsBetweenBraces(commandString);
		}
		
		parseCommandsBetweenBraces(enclosedCommands, objectQueue);
		
		return returnValue;
	}

}
