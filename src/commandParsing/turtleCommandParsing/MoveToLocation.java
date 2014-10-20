package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.Location;
import state.State;
import state.Turtle;

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
		Location destination = getDestinationLocation(components);
		Location turtleLocation = new Location(destination);

		for(Turtle t : state.turtles.getActiveTurtles()){
			turtleLocation = new Location(t.getLocation());
			t.setLocation(destination);
			t.rotate(getDestinationHeading(state));
			if(t.pen.isPenDown()){
	            objectQueue.add(generateDrawableObjectRepresentingLine(turtleLocation, destination));
	        }
	        objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
		}
        return distanceBetweenPoints(turtleLocation,destination);
	}

	protected abstract Location getDestinationLocation(List<Double> components);

	protected abstract double getDestinationHeading(State state);
	
	private double distanceBetweenPoints(Location firstPoint, Location secondPoint){
		return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(),2) 
				+ Math.pow(secondPoint.getY() - firstPoint.getY(),2));
	}
}
