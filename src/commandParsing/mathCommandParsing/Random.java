package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Random extends OneInputFloatCommandParser {

	public static final java.util.Random rand = new java.util.Random();
	
	public Random(State someState) {
		super(someState);
	}
	
	@Override
	protected double operateOnComponents(List<Double> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		double randomNum = rand.nextFloat()*(components.get(0));
		return randomNum;
	}
}
