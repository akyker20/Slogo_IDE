package commandParsing.drawableObectGenerationInterfaces;

import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import gui.factories.LineFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import state.State;
import drawableobject.DrawableObject;

public interface LineGenerator {
	
	default public DrawableObject generateDrawableObjectRepresntingLine(double distanceToMove, State state){
		String parent = ComponentInitializer.GRID_DRAWER;
		String type = FactoryInitializer.LINE_FACTORY;
		Map<String, String> parameters = new HashMap<String, String>();
		
		
		
		parameters.put(LineFactory.ORIGIN, calculateOrigin(state)
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		parameters.put(LineFactory.DESTINATION, calculateDestination(distanceToMove,state)
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		
		return new DrawableObject(parent, type, parameters);
	}
	
	default public List<Double> calculateOrigin(State state){
		@SuppressWarnings("serial")
		List<Double> origin = new ArrayList<Double>(){{
			add(state.getTurtleXLocation());
			add(state.getTurtleYLocation());
		}};
		
		return origin; 
	}
	
	default public List<Double> calculateDestination(double distanceToMove, State state) {
		double heading = state.getHeading();
		List<Double> origin = calculateOrigin(state);
		double xDisplacement = distanceToMove*Math.cos(heading/(180/Math.PI));
		double yDisplacement = distanceToMove*Math.sin(heading/(180/Math.PI));
		@SuppressWarnings("serial")
		List<Double> destination = new ArrayList<Double>(){{
			add(origin.get(0) + xDisplacement);
			add(origin.get(1) + yDisplacement);
		}};
		
		return destination;
	}
}
