package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import workspaceState.Location;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;
import drawableobject.DrawableObject;

public class SetTowards extends TwoInputFloatCommandParser implements TurtleGenerator {

	public SetTowards(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	private final double[] northVector = vectorFromTwoPoints(new Location(workspace.turtles
			.getLastActiveTurtle().getTurtleXLocation(), 0), new Location(workspace.turtles
			.getLastActiveTurtle().getTurtleXLocation() + 1, 0));

	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {

		double angleToRotate = 0;
		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			double heading = 90 - t.getHeading();
			Location turtleLocation = new Location(t.getTurtleXLocation(), t.getTurtleYLocation());
			Location pointLocation = new Location(components.get(0), components.get(1));
			double[] turtleHeadingVector = vectorFromAngle(heading);
			double[] turtleToPointVector = vectorFromTwoPoints(turtleLocation, pointLocation);

			double angleFromTurtleVectorToNorth = angleToNorth(turtleHeadingVector);
			double angleFromPointVectorToNorth = angleToNorth(turtleToPointVector);
			double angleFromTurtleVectorToPointVector = angleBetweenVectors(turtleHeadingVector,
					turtleToPointVector);

			if (angleFromTurtleVectorToPointVector < angleFromTurtleVectorToNorth
					+ angleFromPointVectorToNorth) {
				if (angleFromTurtleVectorToNorth < angleFromPointVectorToNorth) {
					angleToRotate = angleFromPointVectorToNorth - angleFromTurtleVectorToNorth;
				} else if (angleFromTurtleVectorToNorth > angleFromPointVectorToNorth) {
					angleToRotate = -(angleFromTurtleVectorToNorth - angleFromPointVectorToNorth);
				} else {
					angleToRotate = 0;
				}
			} else {
				angleToRotate = -angleFromTurtleVectorToPointVector;
			}

			t.rotate(angleToRotate);
			generateDrawableObjectRepresentingTurtle(t);
		}
		return Math.abs(angleToRotate);
	}

	private double angleToNorth(double[] vector) {
		return angleBetweenVectors(vector, northVector);
	}

	private double[] vectorFromTwoPoints(Location firstPoint, Location secondPoint) {
		double[] vector = { secondPoint.getX() - firstPoint.getX(), secondPoint.getY() - firstPoint.getY() };
		return vector;
	}

	private double[] vectorFromAngle(double angle) {
		double[] vector = { Math.cos((90 - angle) / (180 / Math.PI)),
				Math.sin((90 - angle) / (180 / Math.PI)) };
		return vector;
	}

	private double angleBetweenVectors(double[] firstVector, double[] secondVector) {
		return Math.acos(dotProduct(firstVector, secondVector)
				/ (magnitude(firstVector) * magnitude(secondVector)));
	}

	private double dotProduct(double[] firstVector, double[] secondVector) {
		double dotProduct = 0;
		for (int i = 0; i < firstVector.length; i++) {
			dotProduct += firstVector[i] * secondVector[i];
		}
		return dotProduct;
	}

	private double magnitude(double[] vector) {
		double magnitude = 0;
		for (double d : vector) {
			magnitude += Math.pow(d, 2);
		}
		return Math.sqrt(magnitude);
	}

}
