package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;


public class Right extends OneInputFloatCommandParser implements TurtleGenerator{

	@Override
   	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		state.rotateRight(expressionComponents.get(0));
        objectQueue.add(generateDrawableObjectRepresntingTurtle(state));
   		return expressionComponents.get(0);
   	}

}
