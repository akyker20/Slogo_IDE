package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import workspaceState.Location;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.SLOGOException;
import drawableobject.DrawableObject;

public class MakeTurtle extends CommandParser implements TurtleGenerator {

	public MakeTurtle(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		Turtle newTurtle = new Turtle();
		workspace.turtles.addTurtle(newTurtle);
		objectQueue.add(generateDrawableObjectRepresentingTurtle(newTurtle));
		return 0;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * @Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		double distance = expressionComponents.get(0);

		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			Location initialLocation = new Location(t.getLocation());
			t.move(distanceToMove(distance));
			Location finalLocation = t.getLocation();
			if (t.pen.isPenDown()) {
				objectQueue.add(generateDrawableObjectRepresentingLine(initialLocation, finalLocation));
			}
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
		return distance;
	}
	
	public PenUp(WorkspaceState someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString, Queue<DrawableObject> objectQueue)
			throws SLOGOException {
		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			t.pen.togglePenUp();
		}
		return 0;
	}
	
	@Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		Location destination = getDestinationLocation(components);
		Location turtleLocation = new Location(destination);

		for (Turtle t : workspace.turtles.getActiveTurtles()) {
			turtleLocation = new Location(t.getLocation());
			t.setLocation(destination);
			t.rotate(getDestinationHeading(workspace));
			if (t.pen.isPenDown()) {
				objectQueue.add(generateDrawableObjectRepresentingLine(turtleLocation, destination));
			}
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
		return distanceBetweenPoints(turtleLocation, destination);
	}

	protected abstract Location getDestinationLocation(List<Double> components);

	protected abstract double getDestinationHeading(WorkspaceState workspace);

	private double distanceBetweenPoints(Location firstPoint, Location secondPoint) {
		return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2)
				+ Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
	}
	 */

}
