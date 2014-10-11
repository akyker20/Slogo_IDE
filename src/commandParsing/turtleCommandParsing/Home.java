package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.DeepCopy;
import state.State;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.LineGenerator;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class Home extends CommandParser implements LineGenerator, TurtleGenerator{

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		double xMovement = -state.getTurtleXLocation();
		double yMovement = -state.getTurtleYLocation();		
        double distance = Math.sqrt(Math.pow(xMovement, 2)+Math.pow(yMovement,2));
        
		State initialState = (State) DeepCopy.deepCopy(state);
		state.move(xMovement, yMovement);
		state.rotate(-state.getHeading());
		if(state.isPenDown()){
            objectQueue.add(generateDrawableObjectRepresntingLine(initialState, state));
        }
        objectQueue.add(generateDrawableObjectRepresentingTurtle(state));
        return distance;
	}

}
