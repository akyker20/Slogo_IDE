package commandParsing.structuralCommandParsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import commandParsing.exceptions.SLOGOException;
import commandParsing.variableCommandParsing.Variable;
import drawableobject.DrawableObject;

public abstract class StructuralCommand extends CommandParser {

	public StructuralCommand(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	protected List<String> enclosedCommands;
	protected double returnValue;

	protected void checkForOpeningBrace(Iterator<String> commandString) throws CompileTimeParsingException {
		String stringOfInterest = commandString.next();
		if (!workspace.translator.matchesListStartPattern(stringOfInterest)) {
			throw new CompileTimeParsingException("expected opening brace");
		}
	}

	protected void checkForClosingBrace(Iterator<String> commandString) throws CompileTimeParsingException {
		String stringOfInterest = commandString.next();
		if (!workspace.translator.matchesListEndPattern(stringOfInterest)) {
			throw new CompileTimeParsingException("expected closing brace");
		}
	}

	protected void extractCommandsBetweenBraces(Iterator<String> commandString)
			throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
		List<String> commandList = new ArrayList<String>();
		checkForOpeningBrace(commandString);
		String stringOfInterest = commandString.next();
		while (!workspace.translator.matchesListEndPattern(stringOfInterest) & commandString.hasNext()) {
			commandList.add(stringOfInterest);
			stringOfInterest = commandString.next();
		}

		if (!commandString.hasNext() && !workspace.translator.matchesListEndPattern(stringOfInterest)) {
			throw new CompileTimeParsingException("expected closing brace");
		}

		enclosedCommands = commandList;
	}

	protected void parseCommandsBetweenBraces(Iterator<String> commands, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		double value = 0;
		while (commands.hasNext()) {
			String stringOfInterest = commands.next();
			CommandParser parser = (CommandParser) createParser(stringOfInterest, workspace);
			value = parser.parse(commands, objectQueue);
		}

		returnValue = value;
	}

	protected void setEnclosedCommandsToEmptyList() {
		enclosedCommands = Collections.<String> emptyList();
	}

	protected void ignoreUntilClosingBrace(Iterator<String> commandString) throws CompileTimeParsingException {
		checkForOpeningBrace(commandString);
		boolean stoppedParsingBeforeEndOfString = findBrace(commandString);
		if (!stoppedParsingBeforeEndOfString) {
			throw new CompileTimeParsingException("expected closing brace");
		}
	}

	private boolean findBrace(Iterator<String> commandString) {
		do {
			String stringOfInterest = commandString.next();
			if (workspace.translator.matchesListEndPattern(stringOfInterest)) {
				return true;
			} else if (workspace.translator.matchesListStartPattern(stringOfInterest)) {
				findBrace(commandString);
			}
		} while (commandString.hasNext());
		return false;
	}

	protected String getVariable(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		CommandParser commandParser = (CommandParser) createParser(commandString.next(), workspace);
		if (!(commandParser instanceof Variable)) {
			throw new CompileTimeParsingException("expected variable name");
		}
		Variable variableParser = (Variable) commandParser;
		try {
			variableParser.parse(commandString, objectQueue);
		} catch (RunTimeDivideByZeroException | RunTimeNullPointerException e) {
		}
		String variableName = variableParser.getVariableName();
		return variableName;
	}
}
