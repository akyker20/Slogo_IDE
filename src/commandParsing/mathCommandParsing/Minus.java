package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class Minus extends OneInputFloatCommandParser {
	
	public Minus(State someState) {
		super(someState);
	}

	@Override
	protected double operateOnComponents(List<Double> components,	Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		return -components.get(0);
	}

}
