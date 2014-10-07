package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import stateUpdate.IfElse;
import stateUpdate.StateUpdate;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;

import drawableobject.DrawableObject;


public class If extends StructuralCommand {

	@Override
	public float parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException {

		accumulateComponents(commandString,1,objectQueue);
		String booleanSwitch = expressionComponents.get(0);
		Queue<StateUpdate> ifTrue = new LinkedList<StateUpdate>();
		
		String stringOfInterest = commandString.next();
		String returnValue;
		
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
		else{
			returnValue = generateQueueBetweenBraces(commandString, ifTrue);
		}
		
		objectQueue.add(new IfElse(booleanSwitch,ifTrue,new LinkedList<StateUpdate>()));

		return returnValue;
	}

}
