package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;

import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.SLOGOException;

import drawableobject.DrawableObject;

public class ClearStamps extends CommandParser implements TurtleGenerator {

	public ClearStamps(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		for(Turtle stamp : workspace.turtles.getStamps()){
			objectQueue.add(generateDrawableObjectRepresentingTurtleDeletion(stamp));
		}
		workspace.turtles.removeAllStamps();
		return 0;
	}

}
