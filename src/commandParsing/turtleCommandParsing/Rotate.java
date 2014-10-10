package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public abstract class Rotate extends OneInputFloatCommandParser implements TurtleGenerator {

	@Override
   	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		double rotation = expressionComponents.get(0); 
		state.rotateRight(amountToRotate(rotation));
        objectQueue.add(generateDrawableObjectRepresntingTurtle(state));
   		return rotation;
   	}
	
	abstract protected double amountToRotate(double rotation);

}
