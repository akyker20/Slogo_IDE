package commandParsing.userCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import workspaceState.UserDefinedCommandCollection.Command;
import commandParsing.CommandParser;
import commandParsing.NullCommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class UserInstruction extends CommandParser {

	public UserInstruction(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	private Command command;

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		String commandName = commandString.next();
		command = workspace.commands.fetchUserDefinedCommand(commandName);
		accumulateComponents(commandString, command.getNumArguments(), objectQueue);
		for (int i = 0; i < command.getParameters().size(); i++) {
			workspace.variables.storeVariable(command.getParameters().get(i), expressionComponents.get(i));
		}
		Iterator<String> thisCommandIterator = command.getCommandIterator();
		double returnValue = 0;
		while (thisCommandIterator.hasNext()) {
			CommandParser parser = new NullCommandParser(workspace);
			parser = CommandParser.createParser(thisCommandIterator.next(), workspace);
			returnValue = parser.parse(thisCommandIterator, objectQueue);
		}
		return returnValue;

	}

	@Override
	protected void accumulateComponents(Iterator<String> commandString, int numberToAccumulate,
			Queue<DrawableObject> objectQueue) throws CompileTimeParsingException,
			RunTimeDivideByZeroException, RunTimeNullPointerException {
		expressionComponents.clear();
		while (expressionComponents.size() < numberToAccumulate) {
			if (!commandString.hasNext()) {
				double defaultValueOfParameter = workspace.variables.fetchVariable(command.getParameters()
						.get(expressionComponents.size()));
				expressionComponents.add(defaultValueOfParameter);
			} else {
				String stringOfInterest = commandString.next();

				if (isStringParsableAsCommand(stringOfInterest)) {
					CommandParser commandParser = (CommandParser) createParser(stringOfInterest, workspace);
					expressionComponents.add(commandParser.parse(commandString, objectQueue));
				} else {
					objectQueue.clear();
					throw new CompileTimeParsingException(stringOfInterest);
				}
			}
		}
	}

}
