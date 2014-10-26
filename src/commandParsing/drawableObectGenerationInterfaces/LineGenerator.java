package commandParsing.drawableObectGenerationInterfaces;

import gui.factories.LineFactory;
import java.util.HashMap;
import java.util.Map;
import workspaceState.Location;
import workspaceState.Pen;
import drawableobject.DrawableObject;


public interface LineGenerator {

    default public DrawableObject generateDrawableObjectRepresentingLine (Location initialLocation,
                                                                          Location finalLocation,
                                                                          Pen pen) {
        String parent = LineFactory.PARENT;
        String type = LineFactory.TYPE;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(LineFactory.ORIGIN, initialLocation.generateLocationString());
        parameters.put(LineFactory.DESTINATION, finalLocation.generateLocationString());
        parameters.put(LineFactory.LINE_WIDTH, Double.toString(pen.getPenSize()));
        parameters.put(LineFactory.LINE_COLOR, pen.getPenColor().toString());
        return new DrawableObject(parent, type, parameters);
    }

}
