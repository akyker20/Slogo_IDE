package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Minus extends OneInputFloatCommandParser {
	
	public Minus(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return -components.get(0);
	}

}
