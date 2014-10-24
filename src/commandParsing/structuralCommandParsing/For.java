package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class For extends RecurringCommand {

	public For(State someState) {
		super(someState);
	}

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		checkForOpeningBrace(commandString);
		loopVariable = getVariable(commandString,objectQueue);
		try {
			if(!state.translator.matchesVariablePattern(loopVariable)){
				throw new CompileTimeParsingException("expected variable name: " + loopVariable);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accumulateComponents(commandString, 3, objectQueue);
		double start = expressionComponents.get(0);
		loopVariableBound = expressionComponents.get(1);
		incrementAmount = expressionComponents.get(2);
		state.variables.storeVariable(loopVariable, start);
		checkForClosingBrace(commandString);
	}
}
