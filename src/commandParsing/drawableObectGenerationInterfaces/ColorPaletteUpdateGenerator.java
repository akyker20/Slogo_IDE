package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.ColorPaletteEntryFactory;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.paint.Color;
import drawableobject.DrawableObject;

public interface ColorPaletteUpdateGenerator {

	default public DrawableObject generateDrawableObjectRepresentingColorPaletteUpdate(int index, Color color) {
		String parent = ColorPaletteEntryFactory.PARENT;
		String type = ColorPaletteEntryFactory.TYPE;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ColorPaletteEntryFactory.INDEX, Integer.toString(index));
		parameters.put(ColorPaletteEntryFactory.COLOR, color.toString());
		return new DrawableObject(parent, type, parameters);
	}
}
