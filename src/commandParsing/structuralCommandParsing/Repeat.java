package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class Repeat extends RecurringCommand {

	public Repeat(State someState) {
		super(someState);
	}

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		loopVariable = ":repcount";
		basicLoopVariableInitialization(commandString, objectQueue);
	}
}
