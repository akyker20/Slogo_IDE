package commandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import stateUpdate.StateUpdate;

import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;

public abstract class FloatInputCommandParser extends CommandParser {
	
	@Override
	public String parse(Iterator<String> commandString, Queue<StateUpdate> updateQueue) throws CompileTimeParsingException, RunTimeDivideByZeroException {
		accumulateComponents(commandString, getNumberOfArguments(), updateQueue);
		return operateOnComponents(expressionComponents, updateQueue);
	}
	
	protected abstract int getNumberOfArguments();
	
	protected abstract String operateOnComponents(List<String> components, Queue<StateUpdate> updateQueue) throws RunTimeDivideByZeroException;

}
