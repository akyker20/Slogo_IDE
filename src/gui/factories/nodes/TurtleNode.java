package gui.factories.nodes;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.TurtleFactory;
import java.io.FileNotFoundException;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a turtle node on the screen. Turtles nodes can be selected by the
 * user by clicking on them and their position on the screen can be updated
 * by incoming drawable objects (the result of user commands).
 * @author Austin Kyker
 *
 */
public class TurtleNode extends ImageView {

    private static final String DEFAULT_TURTLE_IMAGEPATH = "turtle_image.png";
    private static final String SELECTED_TURTLE_IMAGEPATH = "selected_turtle.png";

    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.05;
    private static final double TURTLE_IMAGE_WIDTH = TurtleScreenDrawer.GRID_WIDTH *
            TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.1;
    private static final double TURTLE_IMAGE_HEIGHT = TurtleScreenDrawer.GRID_HEIGHT *
            TURTLE_IMAGE_HEIGHT_RATIO;

    private boolean isSelected;

    public TurtleNode(Map<String, String> params) throws FileNotFoundException {
        updateImage(DEFAULT_TURTLE_IMAGEPATH);
        updatePosition(params);
        setOnMouseClicked(event->selectTurtle());
    }

    /**
     * Updates the position of a turtle based on the location parameters specified by the 
     * params map delivered in the drawable object.
     * @param params
     * @return
     */
    public TurtleNode[] updatePosition(Map<String, String> params){
        double[] newLocation = parseStringToPoints(params.get(TurtleFactory.LOCATION));
        setLayoutX(newLocation[0] + TurtleScreenDrawer.GRID_WIDTH/2 - TURTLE_IMAGE_WIDTH/2);
        setLayoutY(- newLocation[1] + TurtleScreenDrawer.GRID_HEIGHT/2 - TURTLE_IMAGE_HEIGHT/2);
        setRotate(Double.parseDouble(params.get(TurtleFactory.HEADING)));
        setOpacity(Double.parseDouble(params.get(TurtleFactory.OPACITY))); 
        return new TurtleNode[]{ this };
    }

    /**
     * Converts the location string to a double array of points.
     * @param point
     * @return
     */
    private double[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");
        return new double[]{ Double.parseDouble(splitPoint[0]),
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
            if(isSelected) {
                updateImage(SELECTED_TURTLE_IMAGEPATH);
            }
            else {
                updateImage(DEFAULT_TURTLE_IMAGEPATH);
            }
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Updates the image of the turtle to be the image located at the input
     * imagePath
     * @param imagePath
     * @throws FileNotFoundException
     */
    private void updateImage(String imagePath) throws FileNotFoundException {
        setImage(new Image(getClass().getResourceAsStream(imagePath),
                           TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                           false, true));
    }
    
    public boolean isSelected(){
        return isSelected;
    }
}
