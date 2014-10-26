package Control;

import java.util.Queue;
import drawableobject.DrawableObject;


/**
 * Class defines the methods that the back-end uses to access front-end resources
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */
public interface SlogoBackend {
    /**
     * This method delivers the Queue of DrawableObjects to the front-end,
     * that have been created after parsing of String commands
     *
     * @param objects
     */
    void drawDrawableObjects (Queue<DrawableObject> objects);
}
