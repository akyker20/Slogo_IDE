package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;
import state.Turtle;

import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class PenDown extends CommandParser {

	public PenDown(State someState) {
		super(someState);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		
		for(Turtle t : state.turtles.getActiveTurtles()){
			t.pen.togglePenDown();
		}
		return 1;
	}

}
