package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class GetPenColor extends CommandParser {

	public GetPenColor(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandStringIterator, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		double index = 0;
		for(Turtle t : workspace.turtles.getActiveTurtles()){
			index = workspace.colorPalette.getIndexFromItem(t.pen.getPenColor());
		}
		return index;
	}

}
