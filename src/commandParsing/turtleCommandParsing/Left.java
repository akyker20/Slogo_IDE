package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;


public class Left extends OneInputFloatCommandParser {

    
    @Override
   	protected double operateOnComponents(List<Float> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		state.rotateLeft(expressionComponents.get(0));
           objectQueue.add(new DrawableObject());
   		return expressionComponents.get(0);
   	}

}
