package commandParsing.variableCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class Variable extends CommandParser {

	public Variable(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	private String variableName;

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {

		variableName = commandString.next();
		return workspace.variables.fetchVariable(variableName);
	}

	public String getVariableName() {
		return variableName;
	}

}
