package commandParsing.structuralCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class AskWith extends Ask {

	public AskWith(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected void determineTurtlesToActivate(Iterator<String> commands, Queue<DrawableObject> objectQueue)
			throws SLOGOException {

		for (Turtle t : workspace.turtles.getAllTurtles()) {
			double value = 0;
			while (commands.hasNext()) {
				String stringOfInterest = commands.next();
				CommandParser parser = (CommandParser) createParser(stringOfInterest, workspace);
				value = parser.parse(commands, objectQueue);
			}
			if (value != 0) {
				activeTurtleIDList.add(t.getID());
			}
		}

	}

}
