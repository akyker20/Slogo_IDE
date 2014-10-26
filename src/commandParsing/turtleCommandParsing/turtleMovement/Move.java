package commandParsing.turtleCommandParsing.turtleMovement;

import java.util.List;
import java.util.Queue;
import workspaceState.Location;
import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;
import drawableobject.DrawableObject;

/**
 * This is the generic move command used as a superclass for all of the actual move commands that are
 * implemented.
 * 
 * @author Steve Kuznetsov, Stanley Yuan
 *
 */

public abstract class Move extends OneInputFloatCommandParser implements LineGenerator,
TurtleGenerator {

    public Move (WorkspaceState someWorkspace) {
        super(someWorkspace);
    }

    @Override
    protected double operateOnComponents (List<Double> components, Queue<DrawableObject> objectQueue)
            throws RunTimeDivideByZeroException {
        double distance = expressionComponents.get(0);

        for (Turtle t : workspace.turtles.getActiveTurtles()) {
            Location initialLocation = new Location(t.getLocation());
            t.move(distanceToMove(distance));
            Location finalLocation = t.getLocation();
            if (t.pen.isPenDown()) {
                objectQueue.add(generateDrawableObjectRepresentingLine(initialLocation,
                                                                       finalLocation, t.pen));
            }
            objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
        }
        return distance;
    }

    abstract protected double distanceToMove (double distance);

}
