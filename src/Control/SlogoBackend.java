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

    /**
     * Returns information to create or edit a variable held in the SlogoControl
     *
     * @param name
     * @param value
     * @return
     */
    DrawableObject setVariable (String name, int value);

    /**
     * Returns a valid command string that will be saved in SlogoControl for future use
     *
     * @param commands
     */
    void saveCommandsToFunction (String commands);
}
