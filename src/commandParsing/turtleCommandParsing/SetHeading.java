package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import workspace.Turtle;
import workspace.Workspace;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public class SetHeading extends OneInputFloatCommandParser implements TurtleGenerator{

	public SetHeading(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		
		double amountToRotate = 0;
		for(Turtle t : workspace.turtles.getActiveTurtles()){
			amountToRotate = components.get(0) - t.getHeading();
			t.rotate(amountToRotate);
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
		return Math.abs(amountToRotate);
	}

}
