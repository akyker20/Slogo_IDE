package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Sine extends OneInputFloatCommandParser {

	public Sine(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		return (double) Math.sin(components.get(0) / (180 / Math.PI));
	}

}
