package commandParsing.mathCommandParsing;

import java.util.List;
import java.util.Queue;

import state.State;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;
import drawableobject.DrawableObject;


public class Remainder extends TwoInputFloatCommandParser {

	public Remainder(State someState) {
		super(someState);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException {
		if(components.get(0)==0 | components.get(1)==0){
			throw new RunTimeDivideByZeroException();
		}
		return components.get(0) % components.get(1);
	}

}
