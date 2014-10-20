package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.Turtle;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class SetHeading extends OneInputFloatCommandParser implements TurtleGenerator{

	@Override
	protected double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		
		double amountToRotate = 0;
		for(Turtle t : state.turtles.getActiveTurtles()){
			amountToRotate = components.get(0) - t.getHeading();
			t.rotate(amountToRotate);
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
		return Math.abs(amountToRotate);
	}

}
