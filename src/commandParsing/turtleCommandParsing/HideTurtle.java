package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class HideTurtle extends CommandParser implements TurtleGenerator {

	public HideTurtle(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		workspace.turtles.getActiveTurtles().stream().forEach(t -> {
			t.hideTurtle();
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		});
		return 0;
	}

}
