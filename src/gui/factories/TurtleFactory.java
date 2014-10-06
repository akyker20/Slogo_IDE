package gui.factories;

import gui.componentdrawers.GridDrawer;
import gui.turtle.Turtle;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import Control.GUIState;


public class TurtleFactory extends ObjectFactory {
    // degrees from north
    public static final double DEFAULT_TURTLE_HEADING = 0.0;
    public static final Color DEFAULT_TURTLE_PENCOLOR = Color.BLACK;
    public static final boolean DEFAULT_TURTLE_PENDOWN_STATUS = false;
    // turtle starts from center of Grid
    public static final Point2D DEFAULT_TURTLE_LOCATION = new Point2D(GridDrawer.GRID_WIDTH / 2,
                                                                      GridDrawer.GRID_HEIGHT / 2);
    public static final String DEFAULT_TURTLE_IMAGEPATH = "turtle_image0.png";

    public static final double TURTLE_IMAGE_WIDTH_RATIO = 0.05;
    public static final double TURTLE_IMAGE_WIDTH = GridDrawer.GRID_WIDTH *
                                                    TurtleFactory.TURTLE_IMAGE_WIDTH_RATIO;
    public static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.1;
    public static final double TURTLE_IMAGE_HEIGHT = GridDrawer.GRID_HEIGHT *
                                                     TurtleFactory.TURTLE_IMAGE_HEIGHT_RATIO;

    public TurtleFactory (String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        Turtle turtle = new Turtle();
        // register turtle in GUIState, automatically assign turtleID as next integer
        GUIState.turtleMap.put(GUIState.turtleMap.size(), turtle);
        // new turtle gets focus
        GUIState.activeTurtle = GUIState.turtleMap.get(GUIState.turtleMap.size()-1);
        return turtle.getImage();
    }
}
