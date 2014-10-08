package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class ArcTangent extends OneInputFloatCommandParser {
	
	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return (float) Math.atan(components.get(0));
	}

}
