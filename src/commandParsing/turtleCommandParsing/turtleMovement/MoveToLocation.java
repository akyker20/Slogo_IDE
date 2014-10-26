package commandParsing.turtleCommandParsing.turtleMovement;

import java.util.List;
import java.util.Queue;
import workspaceState.Location;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;
import drawableobject.DrawableObject;


public abstract class MoveToLocation extends TwoInputFloatCommandParser implements LineGenerator,
TurtleGenerator {

    public MoveToLocation (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double operateOnComponents (List<Double> components, Queue<DrawableObject> objectQueue)
            throws RunTimeDivideByZeroException {
        Location destination = getDestinationLocation(components);
        Location turtleLocation = new Location(destination);

        for (Turtle t : workspace.turtles.getActiveTurtles()) {
            turtleLocation = new Location(t.getLocation());
            t.setLocation(destination);
            t.rotate(getDestinationHeading(workspace));
            if (t.pen.isPenDown()) {
                objectQueue.add(generateDrawableObjectRepresentingLine(turtleLocation, destination,
                                                                       t.pen));
            }
            objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
        }
        return distanceBetweenPoints(turtleLocation, destination);
    }

    protected abstract Location getDestinationLocation (List<Double> components);

    protected abstract double getDestinationHeading (WorkspaceState workspace);

    private double distanceBetweenPoints (Location firstPoint, Location secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2)
                         + Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
    }
}
