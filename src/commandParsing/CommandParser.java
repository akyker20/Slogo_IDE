package commandParsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import state.Workspace;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandParser {

	protected static Workspace state;
	protected List<Double> expressionComponents = new ArrayList<Double>();

	public void setState(Workspace someState) {
		state = someState;
	}

	public abstract double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException;

	protected void accumulateComponents(Iterator<String> commandString, int numberToAccumulate,
			Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,
			RunTimeDivideByZeroException, RunTimeNullPointerException {
		expressionComponents.clear();
		while (expressionComponents.size() < numberToAccumulate) {
			if (!commandString.hasNext()) {
				throw new CompileTimeParsingException("Ran out of bounds looking for next component");
			}
			String stringOfInterest = commandString.next();

			if (isStringParsableAsCommand(stringOfInterest)) {
				CommandParser commandParser = (CommandParser) createParser(stringOfInterest, state);
				expressionComponents.add(commandParser.parse(commandString, objectQueue));
			}
			else {
				objectQueue.clear();
				throw new CompileTimeParsingException(stringOfInterest);
			}
		}
	}

	protected boolean isStringParsableAsCommand(String string) {
		String[] parts = string.split("\\.");
		return parts[parts.length - 1].matches(state.translator.getCommandPattern());
	}

	public static CommandParser createParser(String commandName, Workspace state)
			throws CompileTimeParsingException {
		try {
			CommandParser parser = (CommandParser) Class.forName(commandName).newInstance();
			parser.setState(state);
			return parser;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new CompileTimeParsingException(commandName);
		}
	}
}
