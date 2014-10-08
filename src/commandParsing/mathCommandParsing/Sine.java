package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Sine extends OneInputFloatCommandParser {

	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return (float) Math.sin(components.get(0)/(180/Math.PI));
	}

}
