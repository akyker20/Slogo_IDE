package commandParsing.colorCommandparsing;

import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class SetShape extends OneInputFloatCommandParser {

	public SetShape(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double index = components.get(0);
		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			t.setShape(workspace.shapePalette.getFromPalette((int) index));
		}
		return index;
	}

}
