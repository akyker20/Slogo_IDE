package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.ColorIndexFactory;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.paint.Color;
import drawableobject.DrawableObject;

public interface ColorIndexGenerator {

        default public DrawableObject generateDrawableObjectRepresentingColorIndex(int index, Color color) {
                String parent = ColorIndexFactory.PARENT;
                String type = ColorIndexFactory.TYPE;
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(ColorIndexFactory.INDEX, "" + index);
                parameters.put(ColorIndexFactory.COLOR, "" + color.toString());
                return new DrawableObject(parent, type, parameters);
        }
}
