package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;

import workspaceState.WorkspaceState;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public abstract class OneInputFloatCommandParser extends FloatInputCommandParser {
	
	public OneInputFloatCommandParser(WorkspaceState someWorkspace) {
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
