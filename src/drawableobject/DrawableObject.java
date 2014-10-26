package drawableobject;

import java.util.Map;


/**
 * Class encapsulates a data type that specifies how to draw something on the screen
 *
 * @author Austin Kyker, Steve Kuznetsov, Stanley Yuan, Allan Kiplagat
 *
 */

public class DrawableObject {

    private String parent;
    private String type;
    private Map<String, String> parameters;

    /**
     *
     * @param someParent
     * @param someType
     * @param rawParameters
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

    @Override
    public String toString () {
        return "Parent: " + parent + ", Type: " + type + ", Parameters: " + parameters.toString();
    }

}
