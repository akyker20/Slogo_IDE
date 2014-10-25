package commandParsing.floatCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class FloatInputCommandParser extends CommandParser {

	public FloatInputCommandParser(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		accumulateComponents(commandString, getNumberOfArguments(), objectQueue);
		return operateOnComponents(expressionComponents, objectQueue);
	}

	protected abstract int getNumberOfArguments();

	protected abstract double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException;

}
