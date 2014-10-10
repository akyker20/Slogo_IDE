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
		
		parameters.put(TurtleFactory.HEADING, String.valueOf(calculateHeading(state)));
		parameters.put(TurtleFactory.LOCATION, calculateLocation(state)
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		
		return new DrawableObject(parent, type, parameters);
	}

	default public double calculateHeading(State state){
		return state.getHeading();
	}

	default public List<Double> calculateLocation(State state){
		@SuppressWarnings("serial")
		List<Double> origin = new ArrayList<Double>(){{
			add(state.getTurtleXLocation());
			add(state.getTurtleYLocation());
		}};
		
		return origin; 
	}
	
}
