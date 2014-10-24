package commandParsing;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandParser {

	protected static Workspace workspace;
	protected List<Double> expressionComponents = new ArrayList<Double>();
	
	public CommandParser(Workspace someWorkspace) {
		workspace = someWorkspace;
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
				CommandParser commandParser = (CommandParser) createParser(stringOfInterest, workspace);
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
		return parts[parts.length - 1].matches(workspace.translator.getCommandPattern());
	}

	public static CommandParser createParser(String commandName, Workspace workspace)
			throws CompileTimeParsingException {
		try {
			return (CommandParser) Class.forName(commandName)
					                    .getConstructor(Workspace.class)
					                    .newInstance(workspace);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CompileTimeParsingException(commandName);
		}
	}
}
