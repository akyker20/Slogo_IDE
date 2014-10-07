package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import stateUpdate.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class IfElse extends StructuralCommand {
	
	private State savedState;
	private List<State> storedStates = new ArrayList<State>();
	
	@Override
	public float parse(Iterator<String> commandString,	Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,	RunTimeDivideByZeroException, RunTimeNullPointerException {

		accumulateComponents(commandString,1,objectQueue);
		float booleanSwitch = expressionComponents.get(0);
		Queue<DrawableObject> toDisplay = new LinkedList<DrawableObject>();
		
		float returnValue;
		
		checkForOpeningBrace(commandString);
		
		if (booleanSwitch==1){ 
			returnValue = generateQueueBetweenBraces(commandString, toDisplay);
			ignoreUntilClosingBrace(commandString);
		} 
		else {
			ignoreUntilClosingBrace(commandString);
			checkForOpeningBrace(commandString);
			returnValue = generateQueueBetweenBraces(commandString, toDisplay);
		}
			
		objectQueue.addAll(toDisplay);
		return returnValue;
	}

}
