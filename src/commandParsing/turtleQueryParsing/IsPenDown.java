package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class IsPenDown extends CommandParser {

	public IsPenDown(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		return workspace.turtles.getLastActiveTurtle().pen.isPenDown() ? 1 : 0;
	}

}
