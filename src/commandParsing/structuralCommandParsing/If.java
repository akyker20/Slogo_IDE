package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import stateUpdate.IfElse;
import stateUpdate.StateUpdate;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;


public class If extends StructuralCommand {

	@Override
	public float parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {

		accumulateComponents(commandString,1,objectQueue);
		float booleanSwitch = expressionComponents.get(0);
		Queue<DrawableObject> ifTrue = new LinkedList<DrawableObject>();
		
		String stringOfInterest = commandString.next();
		float returnValue = 0;
		
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
		else if(booleanSwitch!=0){
			returnValue = generateQueueBetweenBraces(commandString, ifTrue);
		}
		else {
			ignoreUntilClosingBrace(commandString);
		}
		
		objectQueue.addAll(ifTrue);

		return returnValue;
	}

}
