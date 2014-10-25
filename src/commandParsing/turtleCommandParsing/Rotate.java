package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

public abstract class Rotate extends OneInputFloatCommandParser implements TurtleGenerator {

	public Rotate(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double rotation = expressionComponents.get(0);

		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			t.rotate(amountToRotate(rotation));
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
		return rotation;
	}

	abstract protected double amountToRotate(double rotation);

}
