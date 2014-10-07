package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import stateUpdate.StateUpdate;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class IfElse extends StructuralCommand {

	@Override
	public float parse(Iterator<String> commandString,	Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,	RunTimeDivideByZeroException, RunTimeNullPointerException {

		accumulateComponents(commandString,1,objectQueue);
		float booleanSwitch = expressionComponents.get(0);
		Queue<DrawableObject> ifTrue = new LinkedList<DrawableObject>();
		Queue<DrawableObject> ifFalse = new LinkedList<DrawableObject>();
		
		String stringOfInterest = commandString.next();
		float firstPossibleReturnValue;
		float secondPossibleReturnValue;
		
		
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
		else{
			firstPossibleReturnValue = generateQueueBetweenBraces(commandString, ifTrue);
			secondPossibleReturnValue = generateQueueBetweenBraces(commandString, ifFalse);
		}
		
		Queue<DrawableObject> toDisplay = new LinkedList<DrawableObject>();
		float returnValue = 0;
		if(booleanSwitch==0){
			returnValue = secondPossibleReturnValue;
			toDisplay = ifFalse;
		}
		else{
			returnValue = firstPossibleReturnValue;
			toDisplay = ifTrue;
		}
		
		objectQueue.addAll(toDisplay);
		return returnValue;
	}

}
