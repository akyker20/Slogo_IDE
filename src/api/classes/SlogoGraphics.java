package api.classes;

import java.util.Queue;
import drawableobject.DrawableObject;


/**
 * Class defines methods accessible to the GUIController
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */
public interface SlogoGraphics {

    /**
     * Methods delivers a String command to the back-end to be parsed into
     * a Queue of DrawableObjects that can be translated in to shapes that are displayed
     * on the screen
     *
     * @param command
     * @return
     */
    Queue<DrawableObject> parseCommandString (String command);
}
