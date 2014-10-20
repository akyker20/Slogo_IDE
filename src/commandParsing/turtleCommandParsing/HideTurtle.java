package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class HideTurtle extends CommandParser implements TurtleGenerator {

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		state.turtles.getActiveTurtles().stream().forEach(t -> {
			t.hideTurtle();
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
			}); 
		return 0;
	}

}
