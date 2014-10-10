package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.TurtleFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import state.State;
import drawableobject.DrawableObject;

public interface TurtleGenerator {
	default public DrawableObject generateDrawableObjectRepresntingTurtle(State state){
		String parent = TurtleFactory.PARENT;
		String type = TurtleFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		
		parameters.put(TurtleFactory.HEADING, String.valueOf(state.getHeading()));
		parameters.put(TurtleFactory.LOCATION, state.calculateLocation()
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		
		return new DrawableObject(parent, type, parameters);
	}
}
