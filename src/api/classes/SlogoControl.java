package api.classes;

import java.util.Queue;
import javafx.stage.Stage;
import drawableobject.DrawableObject;


/**
 * Class sets up the control that separates the front-end and the back-end
 * The class implements both SlogoGraphics and SlogoBackend interfaces and delivers
 * an instance of itself to the GUIController and BackEndController
 *
 * @author akyker20, steven, stanley, allankiplagat
 *
 */
public class SlogoControl implements SlogoGraphics, SlogoBackend {
    /**
     * Initializes the GUIController and BackEndController,
     * providing a SlogoGraphics instance of itself to the front-end
     * and a SlogoBackEnd instance of itself to the back-end
     *
     * @param stage
     */
    public SlogoControl (Stage stage) {
    }

    @Override
    public void drawDrawableObjects (Queue<DrawableObject> objects) {

    }

    @Override
    public DrawableObject setVariable (String name, int value) {
        return null;
    }

    @Override
    public void saveCommandsToFunction (String commands) {

    }

    @Override
    public Queue<DrawableObject> parseCommandString (String command) {
        return null;
    }

}
