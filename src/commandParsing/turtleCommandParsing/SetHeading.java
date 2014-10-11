package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public class SetHeading extends OneInputFloatCommandParser implements TurtleGenerator{

	@Override
	protected double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double amountToRotate = components.get(0) - state.getHeading();
		state.rotate(amountToRotate);
		objectQueue.add(generateDrawableObjectRepresentingTurtle(state));
		return Math.abs(amountToRotate);
	}

}
