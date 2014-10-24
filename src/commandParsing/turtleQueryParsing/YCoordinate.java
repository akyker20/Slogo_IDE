package commandParsing.turtleQueryParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class YCoordinate extends CommandParser {

	public YCoordinate(State someState) {
		super(someState);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		return state.turtles.getLastActiveTurtle().getTurtleYLocation();
	}

}
