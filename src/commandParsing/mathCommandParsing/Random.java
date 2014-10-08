package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class Random extends OneInputFloatCommandParser {

	public static final Random rand = new Random();

	float minX = 50;
	float maxX = 100;

	float finalX = rand.nextFloat() * (maxX - minX) + minX;
	
	@Override
	protected float operateOnComponents(List<Float> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		float randomNum = rand.nextFloat()*(components.get(0));
		return -components.get(0);
	}

}
