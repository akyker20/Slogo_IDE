package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public abstract class OneInputFloatCommandParser extends FloatInputCommandParser {
	
	public OneInputFloatCommandParser(Workspace someWorkspace) {
		super(someWorkspace);
	}


	@Override
	protected int getNumberOfArguments() {
		return 1;
	}


	@Override
	protected abstract double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException;

}
