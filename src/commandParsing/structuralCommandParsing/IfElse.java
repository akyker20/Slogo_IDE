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
		Queue<DrawableObject> ifTrue = new LinkedList<DrawableObject>();
		Queue<DrawableObject> ifFalse = new LinkedList<DrawableObject>();
		
		String stringOfInterest = commandString.next();
		float firstPossibleReturnValue;
		float secondPossibleReturnValue;
		
		
		if(!stringOfInterest.equals("[")){
			throw new CompileTimeParsingException("expected opening brace");
		}
		else{ 
			saveState();
			firstPossibleReturnValue = generateQueueBetweenBraces(commandString, ifTrue);
			storeState();
			restoreState();
			secondPossibleReturnValue = generateQueueBetweenBraces(commandString, ifFalse);
			storeState();
			restoreState();
		}
		
		Queue<DrawableObject> toDisplay = new LinkedList<DrawableObject>();
		float returnValue = 0;
		if(booleanSwitch==0){
			returnValue = secondPossibleReturnValue;
			toDisplay = ifFalse;
			updateState(storedStates.get(1));			
		}
		else{
			returnValue = firstPossibleReturnValue;
			toDisplay = ifTrue;
			updateState(storedStates.get(0));
		}
			
		objectQueue.addAll(toDisplay);
		return returnValue;
	}

	private void updateState(State someState) {
		state = someState;
	}

	private void restoreState() {
		state = savedState.copyState();
	}

	private void storeState() {
		storedStates.add(state);
	}

	private void saveState() {
		savedState = state.copyState();
	}

}
