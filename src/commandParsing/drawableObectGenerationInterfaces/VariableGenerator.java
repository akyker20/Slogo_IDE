package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.RefreshVariablesViewFactory;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public interface VariableGenerator {
	default public DrawableObject generateDrawableObjectRepresentingVariable(){
		String parent = RefreshVariablesViewFactory.PARENT;
		String type = RefreshVariablesViewFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();

		return new DrawableObject(parent, type, parameters);
	}
}
