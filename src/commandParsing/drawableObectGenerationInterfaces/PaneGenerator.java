package commandParsing.drawableObectGenerationInterfaces;

import gui.componentdrawers.ComponentInitializer;
import gui.factories.FactoryInitializer;
import java.util.HashMap;
import java.util.Map;
import drawableobject.DrawableObject;

public interface PaneGenerator {
    default public DrawableObject generateDrawableObjectRepresentingPane(){
        String parent = ComponentInitializer.STAGE_DRAWER;
        String type = FactoryInitializer.CLEAR_GRID_FACTORY;
        Map<String, String> parameters = new HashMap<String, String>();

        return new DrawableObject(parent, type, parameters);
}
}
