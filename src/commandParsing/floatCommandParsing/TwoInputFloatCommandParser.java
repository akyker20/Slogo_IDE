package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Workspace;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public abstract class TwoInputFloatCommandParser extends FloatInputCommandParser {

	public TwoInputFloatCommandParser(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected int getNumberOfArguments() {
		return 2;
	}

	@Override
	protected abstract double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException;

}
