package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;


public class Forward extends OneInputFloatCommandParser implements LineGenerator{

    @Override
	protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
		double distanceToMove = expressionComponents.get(0);
    	state.moveForward(distanceToMove);
        objectQueue.add(generateDrawableObjectRepresntingLine(distanceToMove, state));
		return distanceToMove;
	}

}
