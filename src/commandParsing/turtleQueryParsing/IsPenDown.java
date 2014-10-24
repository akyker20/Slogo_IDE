package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class IsPenDown extends CommandParser {

	public IsPenDown(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		return workspace.turtles.getLastActiveTurtle().pen.isPenDown() ? 1 : 0;
	}

}
