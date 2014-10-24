package commandParsing.booleanCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Not extends OneInputFloatCommandParser {
	
	public Not(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return components.get(0)==0 ? 1 : 0;
	}

}
