package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.EmptyPaneFactory;

import java.util.HashMap;
import java.util.Map;

import drawableobject.DrawableObject;

public interface PaneGenerator {
	default public DrawableObject generateDrawableObjectRepresentingPane() {
		String parent = EmptyPaneFactory.PARENT;
		String type = EmptyPaneFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();

		return new DrawableObject(parent, type, parameters);
	}
}
