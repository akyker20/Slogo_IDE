package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Location;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class MakeTurtle extends CommandParser implements TurtleGenerator {

	public MakeTurtle(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		workspace.turtles.addTurtle();
		Turtle newTurtle = workspace.turtles.getLastAddedTurtle();
		objectQueue.add(generateDrawableObjectRepresentingTurtle(newTurtle));
		return 0;
	}
	


}
