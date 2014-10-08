package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class NaturalLog extends OneInputFloatCommandParser {
	
	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return (float) Math.log(components.get(0));
	}

}
