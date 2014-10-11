package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class For extends RecurringCommand {

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		if(!isStringParsableAsVariable(loopVariable)){
			throw new CompileTimeParsingException(loopVariable + " , expected variable name");
		}
		accumulateComponents(commandString, 3, objectQueue);
		double start = expressionComponents.get(0);
		loopVariableBound = expressionComponents.get(1);
		incrementAmount = expressionComponents.get(2);
		state.storeVariable(loopVariable, start);
	}
}
