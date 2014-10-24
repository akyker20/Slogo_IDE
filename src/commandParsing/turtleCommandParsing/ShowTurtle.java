package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import state.State;

import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

import drawableobject.DrawableObject;

public class ShowTurtle extends CommandParser implements TurtleGenerator {

	public ShowTurtle(State someState) {
		super(someState);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		state.turtles.getActiveTurtles().stream().forEach(t -> {
			t.showTurtle();
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
			});
		return 1;
	}

}
