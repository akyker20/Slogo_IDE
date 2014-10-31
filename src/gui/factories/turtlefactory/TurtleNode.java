// This entire file is part of my masterpiece.
// Austin Kyker

package gui.factories.turtlefactory;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.mainclasses.workspace.Workspace;
import gui.turtlescreenwrap.CoordinateChanger;
import gui.turtlescreenwrap.TesselationMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.sun.javafx.geom.Point2D;


/**
 * This class represents a turtle node on the screen. Turtles nodes can be selected by the
 * user by clicking on them and their position on the screen can be updated
 * by incoming DrawableObjects (the result of user commands).
 *
 * @author Austin Kyker
 *
 */
public class TurtleNode extends ImageView {

    private static final String SELECTED_TURTLE_IMAGEPATH =
            "./src/resources/guiResources/turtleImages/selected_turtle.png";
    private static final String DESELECTED_TURTLE_IMAGEPATH =
            "./src/resources/guiResources/turtleImages/deselected_turtle.png";
    private static final String FILE_UPLOAD_ERROR = "Selected File Could Not Be Found";

    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.06;
    private static final double TURTLE_IMAGE_WIDTH = TurtleScreenDrawer.GRID_WIDTH *
            TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.06;
    private static final double TURTLE_IMAGE_HEIGHT = TurtleScreenDrawer.GRID_HEIGHT *
            TURTLE_IMAGE_HEIGHT_RATIO;
    private static final double POPUP_WIDTH = 100;
    private static final double POPUP_HEIGHT = 100;

    private boolean isSelected;
    private Workspace myWorkspace;
    private String myID;

    /**
     * The constructor initializes instance variables including setting the id
     * of the turtle node and adding the mouse click listener.
     * @param params - the params map of the DrawableObject
     * @param workspace
     * @throws FileNotFoundException
     */
    public TurtleNode (Map<String, String> params, Workspace workspace) {
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
    protected static double[] parseStringToPoints (String point) {
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
        if (isSelected) {
            updateImage(SELECTED_TURTLE_IMAGEPATH);
        }
        else {
            updateImage(DESELECTED_TURTLE_IMAGEPATH);
        }
        myWorkspace.notifyOfTurtleSelectionChange();
    }

    /**
     * Updates the image of the turtle to be the image located at the input
     * imagePath. If the image is not found, a PopUp lets the user know
     * that the image was not found.
     *
     * @param imagePath
     */
    protected void updateImage (String imagePath) {
        try {
            setImage(new Image(new FileInputStream(new File(imagePath)),
                               TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                               false, true));
        }
        catch (FileNotFoundException e) {
            Stage stage = new Stage();
            Group group = new Group();
            group.getChildren().add(new Label(FILE_UPLOAD_ERROR));
            Scene scene = new Scene(group, POPUP_WIDTH, POPUP_HEIGHT);
            stage.setScene(scene);
        }
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
