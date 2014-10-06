package drawableobject;

import java.util.List;
import java.util.Map;


/**
 * Class encapsulates a data type that specifies how to draw something on the screen
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */

public class DrawableObject {

    private String parent;
    private String type;
    private Map<String,String> parameters;


    /**
     *
     * @param someParent The string name of the ComponentDrawer the shape is to be drawn in
     * @param someType The ObjectFactory used to build the shape to be drawn
     * @param someName The name the drawable object
     * @param rawParameters Parameters used by the ObjectFactory to generate a shape
     */

    public DrawableObject (String someParent,
                           String someType,
                           Map<String, String> rawParameters) {
        parent = someParent;
        type = someType;
        parameters = rawParameters;
    }

    public String getParent () {
        return parent;
    }

    public String getType () {
        return type;
    }

    public Map<String, String> getParameters () {
        return parameters;
    }

}
