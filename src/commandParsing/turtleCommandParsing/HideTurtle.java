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
		state.hideTurtle();
		objectQueue.add(generateDrawableObjectRepresentingTurtle(state));
		return 0;
	}

}
