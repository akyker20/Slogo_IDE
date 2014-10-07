package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import stateUpdate.StateUpdate;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;

public class IfElse extends StructuralCommand {

	@Override
	public String parse(Iterator<String> commandString,	Queue<StateUpdate> updateQueue) throws CompileTimeParsingException,	RunTimeDivideByZeroException {

		accumulateComponents(commandString,1,updateQueue);
		String booleanSwitch = expressionComponents.get(0);
		Queue<StateUpdate> ifTrue = new LinkedList<StateUpdate>();
		Queue<StateUpdate> ifFalse = new LinkedList<StateUpdate>();
		
		String stringOfInterest = commandString.next();
		String firstPossibleReturnValue;
		String secondPossibleReturnValue;
		
		
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
		else{
			firstPossibleReturnValue = generateQueueBetweenBraces(commandString, ifTrue);
			secondPossibleReturnValue = generateQueueBetweenBraces(commandString, ifFalse);
		}
		
		updateQueue.add(new stateUpdate.IfElse(booleanSwitch,ifTrue,ifFalse));
		return "IfElse" + " " + booleanSwitch + " " + "[" + " " + firstPossibleReturnValue + " " + "]" + "[" + " " + secondPossibleReturnValue + " " + "]";
	}

}
