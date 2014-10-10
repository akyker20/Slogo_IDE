package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;

import drawableobject.DrawableObject;

public class Power extends TwoInputFloatCommandParser {
	
	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return (float) Math.pow(components.get(0), components.get(1));
	}

}