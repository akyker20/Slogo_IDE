package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspace.Turtle;
import workspace.Workspace;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class PenDown extends CommandParser {

	public PenDown(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		
		for(Turtle t : workspace.turtles.getActiveTurtles()){
			t.pen.togglePenDown();
		}
		return 1;
	}

}
