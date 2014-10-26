package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.PaneFactory;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;
import drawableobject.DrawableObject;

public interface PaneGenerator {
	
	default public DrawableObject generateDrawableObjectRepresentingPaneReset() {
		String parent = PaneFactory.PARENT;
		String type = PaneFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PaneFactory.RESET_FLAG, "true");
		parameters.put(PaneFactory.BACKGROUND_COLOR, Color.WHITE.toString());

		return new DrawableObject(parent, type, parameters);
	}
	
	default public DrawableObject generateDrawableObjectRepresentingPane(Color backgroundColor) {
		String parent = PaneFactory.PARENT;
		String type = PaneFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PaneFactory.RESET_FLAG, "false");
		parameters.put(PaneFactory.BACKGROUND_COLOR, backgroundColor.toString());

		return new DrawableObject(parent, type, parameters);
	}
}
