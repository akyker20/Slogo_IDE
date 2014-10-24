package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class DoTimes extends RecurringCommand {

	public DoTimes(State someState) {
		super(someState);
	}

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		checkForOpeningBrace(commandString);
		loopVariable = getVariable(commandString,objectQueue);
		if(!state.translator.matchesVariablePattern(loopVariable)){
			throw new CompileTimeParsingException("expected variable name: " + loopVariable);
		}
		basicLoopVariableInitialization(commandString, objectQueue);
		checkForClosingBrace(commandString);
	}
}
