package gui.factories.turtlefactory;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.mainclasses.workspace.Workspace;
import gui.turtlescreenwrap.CoordinateChanger;
import gui.turtlescreenwrap.TesselationMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.sun.javafx.geom.Point2D;


/**
 * Represents a turtle node on the screen. Turtles nodes can be selected by the
 * user by clicking on them and their position on the screen can be updated
 * by incoming drawable objects (the result of user commands).
 *
 * @author Austin Kyker
 *
 */
public class TurtleNode extends ImageView {

    private static final String SELECTED_TURTLE_IMAGEPATH =
            "./src/resources/guiResources/turtleImages/selected_turtle.png";
    private static final String DESELECTED_TURTLE_IMAGEPATH =
            "./src/resources/guiResources/turtleImages/deselected_turtle.png";

    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.06;
    private static final double TURTLE_IMAGE_WIDTH = TurtleScreenDrawer.GRID_WIDTH *
            TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.06;
    private static final double TURTLE_IMAGE_HEIGHT = TurtleScreenDrawer.GRID_HEIGHT *
            TURTLE_IMAGE_HEIGHT_RATIO;

    private boolean isSelected;
    private Workspace myWorkspace;
    private String myID;

    public TurtleNode (Map<String, String> params, Workspace workspace)
            throws FileNotFoundException {
        isSelected = true;
        myWorkspace = workspace;
        myID = params.get(TurtleFactory.TURTLE_ID);
        updateImage(SELECTED_TURTLE_IMAGEPATH);
        updatePosition(params);
        setOnMouseClicked(event -> selectTurtle());
    }

    /**
     * Updates the position of a turtle based on the location parameters specified by the
     * params map delivered in the drawable object.
     *
     * @param params
     * @return
     */
    public TurtleNode[] updatePosition (Map<String, String> params) {
        double[] newLocation = parseStringToPoints(params.get(TurtleFactory.LOCATION));

        Point2D dest = new Point2D((float) newLocation[0], (float) newLocation[1]);
        dest = TesselationMapper.map(dest);

        float x = CoordinateChanger.convX(dest.x);
        float y = CoordinateChanger.convY(dest.y);

        setLayoutX(x - getBoundsInParent().getWidth() / 2);
        setLayoutY(y - getBoundsInParent().getHeight() / 2);

        setRotate(Double.parseDouble(params.get(TurtleFactory.HEADING)));
        setOpacity(Double.parseDouble(params.get(TurtleFactory.OPACITY)));
        return new TurtleNode[] { this };
    }

    /**
     * Converts the location string to a double array of points.
     *
     * @param point
     * @return
     */
    private double[] parseStringToPoints (String point) {
        String[] splitPoint = point.split(" ");
        return new double[] { Double.parseDouble(splitPoint[0]),
                              Double.parseDouble(splitPoint[1]) };
    }

    /**
     * This method is called when a turtle is clicked. The image of the turtle changes
     * to make the user aware that the turtle is selected and can be moved interactively
     * using the arrow keys on the keyboard.
     */
    private void selectTurtle () {
        isSelected = !isSelected;
        try {
            if (isSelected) {
                updateImage(SELECTED_TURTLE_IMAGEPATH);
            }
            else {
                updateImage(DESELECTED_TURTLE_IMAGEPATH);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        myWorkspace.notifyOfTurtleSelectionChange();
    }

    /**
     * Updates the image of the turtle to be the image located at the input
     * imagePath
     *
     * @param imagePath
     * @throws FileNotFoundException
     */
    protected void updateImage (String imagePath) throws FileNotFoundException {
        setImage(new Image(new FileInputStream(new File(imagePath)),
                           TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                           false, true));
    }

    /**
     * Returns true if the turtle is selected (green) and false otherwise.
     * @return Boolean
     */
    public boolean isSelected () {
        return isSelected;
    }

    /**
     * Returns the id of the turtle
     * @return String
     */
    public String getTurtleID () {
        return myID;
    }
}
