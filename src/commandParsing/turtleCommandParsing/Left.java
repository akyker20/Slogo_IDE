package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;


public class Left extends OneInputFloatCommandParser implements TurtleGenerator{

    
    @Override
   	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		double amountToRotate = expressionComponents.get(0);
    	state.rotateLeft(amountToRotate);
        objectQueue.add(generateDrawableObjectRepresntingTurtle(state));
   		return amountToRotate;
   	}

}
