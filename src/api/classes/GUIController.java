package api.classes;

import java.util.Queue;
import java.util.ResourceBundle;
import javafx.stage.Stage;


/**
 * Class controls the GUI: initializes the scene and sets up the component
 * drawers, object factories, and features; depends on a SlogoGraphics control object
 *
 * @author allankiplagat, akyker20
 *
 */
public class GUIController {

    public static ResourceBundle GUI_TEXT;

    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     */
    public GUIController (Stage stage, SlogoGraphics control) {

    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     *
     * @param objectQueue
     */
    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
    }
}
