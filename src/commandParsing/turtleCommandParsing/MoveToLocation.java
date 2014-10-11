package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.DeepCopy;
import state.Location;
import state.State;

import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;

import drawableobject.DrawableObject;

public abstract class MoveToLocation extends TwoInputFloatCommandParser implements LineGenerator, TurtleGenerator {

	@Override
	protected double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		Location turtleLocation = new Location(state.getTurtleXLocation(),state.getTurtleYLocation());
		Location destination = getDestinationLocation(components);

		State initialState = (State) DeepCopy.deepCopy(state);
		state.moveToLocation(destination);
		state.rotate(getDestinationHeading(state));
		if(state.isPenDown()){
            objectQueue.add(generateDrawableObjectRepresentingLine(initialState, state));
        }
        objectQueue.add(generateDrawableObjectRepresentingTurtle(state));
        return distanceBetweenPoints(turtleLocation,destination);
	}

	protected abstract Location getDestinationLocation(List<Double> components);

	protected abstract double getDestinationHeading(State state);
	
	private double distanceBetweenPoints(Location firstPoint, Location secondPoint){
		return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(),2) 
				+ Math.pow(secondPoint.getY() - firstPoint.getY(),2));
	}
}
