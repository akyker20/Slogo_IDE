package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class DoTimes extends RecurringCommand {

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		checkForOpeningBrace(commandString);
		loopVariable = commandString.next();
		if(!isStringParsableAsVariable(loopVariable)){
			throw new CompileTimeParsingException(loopVariable + " , expected variable name");
		}
		basicLoopVariableInitialization(commandString, objectQueue);
	}
}
