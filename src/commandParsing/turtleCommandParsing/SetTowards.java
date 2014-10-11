package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.Location;

import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.TwoInputFloatCommandParser;

import drawableobject.DrawableObject;

public class SetTowards extends TwoInputFloatCommandParser implements TurtleGenerator {

	private final double[] northVector = vectorFromTwoPoints(new Location(0,0), new Location(0,1));
	
	@Override
	protected double operateOnComponents(List<Double> components,
			Queue<DrawableObject> objectQueue)
			throws RunTimeDivideByZeroException {
		state.setOpacity(0);
		return 0;
	}
	
	private double angleToNorth(double[] vector){
		return angleBetweenVectors(vector, northVector);
	}
	
	private double[] vectorFromTwoPoints(Location firstPoint, Location secondPoint){
		double[] vector = {secondPoint.getX()-firstPoint.getX(),secondPoint.getY()-firstPoint.getY()};
		return vector;
	}
	
	private double[] vectorFromAngle(double angle){
		double[] vector = {Math.cos((90-angle)/(180/Math.PI)), Math.sin((90-angle)/(180/Math.PI))};
		return vector;
	}
	
	private double angleBetweenVectors(double[] firstVector, double[] secondVector){
		return Math.acos(dotProduct(firstVector,secondVector)/(magnitude(firstVector)*magnitude(secondVector)));
	}
	
	private double dotProduct(double[] firstVector, double[] secondVector){
		double dotProduct = 0;
		for(int i=0;i<firstVector.length;i++){
			dotProduct += firstVector[i] * secondVector[i];
		}
		return dotProduct;
	}
	
	private double magnitude(double[] vector){
		double magnitude = 0;
		for(double d : vector){
			magnitude += Math.pow(d,2);
		}
		return Math.sqrt(magnitude);
	}

}
