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


public class Forward extends OneInputFloatCommandParser implements LineGenerator, TurtleGenerator {

    @Override
    protected double operateOnComponents(List<Double> components, Queue<DrawableObject> objectQueue) throws RunTimeDivideByZeroException{
        double distanceToMove = expressionComponents.get(0);
		State initialState = (State) DeepCopy.deepCopy(state);
		state.move(distanceToMove);
        if(state.isPenDown()){
            objectQueue.add(generateDrawableObjectRepresntingLine(initialState, state));
        }
        objectQueue.add(generateDrawableObjectRepresntingTurtle(state));
        return distanceToMove;
    }

}
