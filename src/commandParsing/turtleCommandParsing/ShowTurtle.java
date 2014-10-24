package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.TurtleCollection;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class ShowTurtle extends CommandParser implements TurtleGenerator {

	public ShowTurtle(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		workspace.turtles.getActiveTurtles().stream().forEach(t -> {
			t.showTurtle();
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		});
		return 1;
	}

}
