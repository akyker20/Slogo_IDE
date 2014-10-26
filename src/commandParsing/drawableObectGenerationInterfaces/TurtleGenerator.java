package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.turtlefactory.TurtleFactory;
import java.util.HashMap;
import java.util.Map;
import workspaceState.Turtle;
import drawableobject.DrawableObject;

public interface TurtleGenerator {
	default public DrawableObject generateDrawableObjectRepresentingTurtle(Turtle turtle) {

		String parent = TurtleFactory.PARENT;
		String type = TurtleFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		
		parameters.put(TurtleFactory.TURTLE_ID, String.valueOf(turtle.getID()));
		parameters.put(TurtleFactory.HEADING, String.valueOf(turtle.getHeading()));
		parameters.put(TurtleFactory.LOCATION, turtle.getLocation().generateLocationString());
		parameters.put(TurtleFactory.OPACITY, String.valueOf(turtle.getOpacity()));
		parameters.put(TurtleFactory.IMAGE_PATH, turtle.getShape().getPath());
		parameters.put(TurtleFactory.DELETION_FLAG, "false");

		return new DrawableObject(parent, type, parameters);
	}
	
	default public DrawableObject generateDrawableObjectRepresentingTurtleDeletion(Turtle turtle) {

		String parent = TurtleFactory.PARENT;
		String type = TurtleFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(TurtleFactory.TURTLE_ID, String.valueOf(turtle.getID()));
		parameters.put(TurtleFactory.DELETION_FLAG, "true");

		return new DrawableObject(parent, type, parameters);
	}
}
