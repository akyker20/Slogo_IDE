package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.Turtle;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public abstract class Rotate extends OneInputFloatCommandParser implements TurtleGenerator {

	@Override
   	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
   		double rotation = expressionComponents.get(0); 
		
   		for(Turtle t : state.turtles.getActiveTurtles()){
   	   		t.rotate(amountToRotate(rotation));
   	        objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
   		}
   		return rotation;
   	}
	
	abstract protected double amountToRotate(double rotation);

}
