package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.variableCommandParsing.Variable;
import drawableobject.DrawableObject;

public class For extends RecurringCommand {

	@Override
	protected void initializeLoopVariableParameters(
			Iterator<String> commandString, Queue<DrawableObject> objectQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		checkForOpeningBrace(commandString);
		CommandParser commandParser = (CommandParser) createParser(commandString.next(), state);
		if(!(commandParser instanceof Variable)){
			throw new CompileTimeParsingException("expected variable name");
		}
		loopVariable = commandString.next();
		if(!loopVariable.matches(state.getVariablePattern())){
			throw new CompileTimeParsingException("expected variable name: " + loopVariable);
		}
		accumulateComponents(commandString, 3, objectQueue);
		double start = expressionComponents.get(0);
		loopVariableBound = expressionComponents.get(1);
		incrementAmount = expressionComponents.get(2);
		state.storeVariable(loopVariable, start);
		checkForClosingBrace(commandString);
	}
}
