package commandParsing.floatCommandParsing;

import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import drawableobject.DrawableObject;

public abstract class OneInputFloatCommandParser extends FloatInputCommandParser {
	
	public OneInputFloatCommandParser(State someState) {
		super(someState);
	}


	@Override
	protected int getNumberOfArguments() {
		return 1;
	}


	@Override
	protected abstract double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException;

}
