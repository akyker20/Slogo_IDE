package commandParsing.variableCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class Variable extends CommandParser {

	public Variable(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	private String variableName;

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {

		variableName = commandString.next();
		return workspace.variables.fetchVariable(variableName);
	}

	public String getVariableName() {
		return variableName;
	}

}
