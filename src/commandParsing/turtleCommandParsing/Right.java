package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;


public class Right extends OneInputFloatCommandParser {

	@Override
   	protected float operateOnComponents(List<Float> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		state.rotateRight(expressionComponents.get(0));
           objectQueue.add(new DrawableObject());
   		return expressionComponents.get(0);
   	}

}
