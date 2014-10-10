package commandParsing.booleanCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;

import drawableobject.DrawableObject;

public class NotEqual extends TwoInputFloatCommandParser {
	
	@Override
	protected double operateOnComponents(List<Double> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return !components.get(0).equals(components.get(1)) ? 1 : 0;
	}


}
