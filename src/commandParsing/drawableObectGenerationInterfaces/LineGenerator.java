package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.LineFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import state.State;
import drawableobject.DrawableObject;

public interface LineGenerator {
	
	default public DrawableObject generateDrawableObjectRepresntingLine(State initialState, State endingState){
		String parent = LineFactory.PARENT;
		String type = LineFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		
		parameters.put(LineFactory.ORIGIN, initialState.calculateLocation()
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		parameters.put(LineFactory.DESTINATION, endingState.calculateLocation()
				                                     .stream()
				                                     .map(p -> p.toString())
				                                     .collect(Collectors.joining(" ")));
		
		return new DrawableObject(parent, type, parameters);
	}
	

}
