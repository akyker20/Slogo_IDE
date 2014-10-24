package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class DoTimes extends RecurringCommand {

	public DoTimes(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		checkForOpeningBrace(commandString);
		loopVariable = getVariable(commandString,objectQueue);
		if(!workspace.translator.matchesVariablePattern(loopVariable)){
			throw new CompileTimeParsingException("expected variable name: " + loopVariable);
		}
		basicLoopVariableInitialization(commandString, objectQueue);
		checkForClosingBrace(commandString);
	}
}
