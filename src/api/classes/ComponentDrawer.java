package api.classes;

import javafx.scene.Node;
import javafx.scene.layout.Pane;


/**
 * Class represents a component of the GUI e.g. GridDrawer
 *
 * @author akyker20, allankiplagat
 *
 */
public abstract class ComponentDrawer extends Pane {

    public ComponentDrawer (String name) {
    }

    /**
     * Draws a shape in this component
     *
     * @param node
     */
    public void drawShape (Node node) {
    }

    /**
     * Returns the name of the component assigned by the constructor
     * This method will be used in the DrawableObjectParser class to parse the
     * correct component in which to draw a shape
     *
     * @return
     */
    public String getName () {
        return null;
    }

}
