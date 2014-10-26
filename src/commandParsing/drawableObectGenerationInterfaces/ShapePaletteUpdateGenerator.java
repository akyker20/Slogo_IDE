package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.ShapePaletteEntryFactory;
import java.util.HashMap;
import java.util.Map;
import workspaceState.Shape;
import drawableobject.DrawableObject;

/**
 * This class generates the actual ShapePaletteUpdate drawableObjects to give to the GUI.
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public interface ShapePaletteUpdateGenerator {
    default public DrawableObject generateDrawableObjectRepresentingShapePaletteUpdate (int index,
                                                                                        Shape shape) {
        String parent = ShapePaletteEntryFactory.PARENT;
        String type = ShapePaletteEntryFactory.TYPE;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ShapePaletteEntryFactory.INDEX, Integer.toString(index));
        parameters.put(ShapePaletteEntryFactory.IMAGE_PATH, shape.getPath());
        return new DrawableObject(parent, type, parameters);
    }
}
