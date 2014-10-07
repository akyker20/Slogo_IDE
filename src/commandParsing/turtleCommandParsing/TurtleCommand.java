package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.FloatInputCommandParser;
import commandParsing.exceptions.RunTimeDivideByZeroException;

import drawableobject.DrawableObject;



/**
 * Class parses String turtle commands into TurtleCommand objects
 *
 * @author steve, stanley
 *
 */

public abstract class TurtleCommand extends FloatInputCommandParser {


	@Override
	protected float operateOnComponents(List<Float> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
		generateUpdate(expressionComponents.get(0), objectQueue);
		return expressionComponents.get(0);
	}
	
	@Override
	protected int getNumberOfArguments() {
		return 1;
	}

	protected abstract void generateUpdate(float amount, Queue<DrawableObject> objectQueue);
}
