package commandParsing.booleanCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;

import drawableobject.DrawableObject;

public class NotEqual extends TwoInputFloatCommandParser {
	
	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return components.get(0) != components.get(1) ? 1 : 0;
	}


}