package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.LineFactory;

import java.util.HashMap;
import java.util.Map;

import workspaceState.Location;
import drawableobject.DrawableObject;

public interface LineGenerator {
	
	default public DrawableObject generateDrawableObjectRepresentingLine(Location initialLocation, Location finalLocation){
		String parent = LineFactory.PARENT;
		String type = LineFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(LineFactory.ORIGIN, initialLocation.generateLocationString());
		parameters.put(LineFactory.DESTINATION, finalLocation.generateLocationString());
		return new DrawableObject(parent, type, parameters);
	}
	

}
