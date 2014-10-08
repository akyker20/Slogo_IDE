package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public abstract class OneInputFloatCommandParser extends FloatInputCommandParser {
	
	@Override
	protected int getNumberOfArguments() {
		return 1;
	}


	@Override
	protected abstract float operateOnComponents(List<Float> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException;

}
