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

    /**
     * The parent represents the drawable component where the drawable object
     * will be drawn.
     * @return String
     */
    public String getParent () {
        return parent;
    }

    /**
     * The type represents the type of factory that will be used to draw the
     * drawable object.
     * @return
     */
    public String getType () {
        return type;
    }

    /**
     * These parameters are used by the factories to build certain nodes.
     * Each different factory will receive different parameters depending
     * on what it needs to know to draw the object it creates.
     * @return
     */
    public Map<String, String> getParameters () {
        return parameters;
    }

    @Override
    public String toString () {
        return "Parent: " + parent + ", Type: " + type + ", Parameters: " + parameters.toString();
    }

}
