package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.TurtleFactory;

import java.util.HashMap;
import java.util.Map;

import workspaceState.Turtle;
import drawableobject.DrawableObject;

public interface TurtleGenerator {
	default public DrawableObject generateDrawableObjectRepresentingTurtle(Turtle turtle) {

		String parent = TurtleFactory.PARENT;
		String type = TurtleFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(TurtleFactory.TURTLE_IMAGE_ID, String.valueOf(turtle.getID()));
		parameters.put(TurtleFactory.HEADING, String.valueOf(turtle.getHeading()));
		parameters.put(TurtleFactory.LOCATION, turtle.getLocation().generateLocationString());
		parameters.put(TurtleFactory.OPACITY, String.valueOf(turtle.getOpacity()));

		return new DrawableObject(parent, type, parameters);
	}
}
