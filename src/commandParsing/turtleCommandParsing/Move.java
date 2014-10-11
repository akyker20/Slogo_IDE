package commandParsing.turtleCommandParsing;

import java.util.List;
import java.util.Queue;

import state.DeepCopy;
import state.State;

import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.floatCommandParsing.OneInputFloatCommandParser;

import drawableobject.DrawableObject;

public abstract class Move extends OneInputFloatCommandParser implements LineGenerator, TurtleGenerator {

    @Override
    protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
        double distance = expressionComponents.get(0);
		State initialState = (State) DeepCopy.deepCopy(state);
		state.move(distanceToMove(distance));
        if(state.isPenDown()){
            objectQueue.add(generateDrawableObjectRepresentingLine(initialState, state));
        }
        objectQueue.add(generateDrawableObjectRepresentingTurtle(state));
        return distance;
    }
	
	abstract protected double distanceToMove(double distance);

}
