package commandParsing.turtleCommandParsing;

import java.util.Iterator;
import java.util.Queue;

import workspace.TurtleCollection;
import workspace.Workspace;
import commandParsing.CommandParser;
import commandParsing.drawableObectGenerationInterfaces.TurtleGenerator;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class ShowTurtle extends CommandParser implements TurtleGenerator {

	public ShowTurtle(Workspace someWorkspace) {
		super(someWorkspace);
	}

	@Override
	public double parse(Iterator<String> commandString,
			Queue<DrawableObject> objectQueue)
			throws CompileTimeParsingException, RunTimeDivideByZeroException,
			RunTimeNullPointerException {
		workspace.turtles.getActiveTurtles().stream().forEach(t -> {
			t.showTurtle();
			objectQueue.add(generateDrawableObjectRepresentingTurtle(t));
			});
		return 1;
	}

}
