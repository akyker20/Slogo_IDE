package commandParsing.turtleCommandParsing.turtleAttributeSetters;

import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class SetPenSize extends OneInputFloatCommandParser {

	public SetPenSize(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double size = components.get(0);
		for(Turtle t : workspace.turtles.getActiveTurtles()){
			t.pen.setPenSize(size);
		}
		return size;
	}

}
