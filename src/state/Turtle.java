package state;

import gui.factories.TurtleFactory;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Turtle {

    private double heading;
    private Color penColor;
    private Point2D location;
    private Node image;
    private boolean penDown;

    public Turtle () {
        penColor = TurtleFactory.DEFAULT_TURTLE_PENCOLOR;
        penDown = TurtleFactory.DEFAULT_TURTLE_PENDOWN_STATUS;
        // call setImage() before setLocation() and setHeading()
        Image im =
                new Image(getClass().getResourceAsStream(TurtleFactory.DEFAULT_TURTLE_IMAGEPATH),
                          TurtleFactory.TURTLE_IMAGE_WIDTH, TurtleFactory.TURTLE_IMAGE_HEIGHT,
                          false, true);
        setImage(new ImageView(im));

        setLocation(TurtleFactory.DEFAULT_TURTLE_LOCATION);
        setHeading(TurtleFactory.DEFAULT_TURTLE_HEADING);
    }

    // TODO I don't think we'll use most of of these getters & setters; remove later
    public double getHeading () {
        return heading;
    }

    public void setHeading (double newHeading) {
        heading = newHeading;
        // TODO: might use binding to achieve this rotate and heading coupling later
        image.setRotate(heading);
    }

    public Color getPenColor () {
        return penColor;
    }

    public void setPenColor (Color newColor) {
        penColor = newColor;
    }

    public Point2D getLocation () {
        return location;
    }

    public void setLocation (Point2D newLocation) {
        location = newLocation;
        // TODO: might use binding to achieve this layout and location coupling later
        //using offset to have placement relative to image center
        image.setLayoutX(location.getX()-image.getBoundsInParent().getWidth()/2);
        image.setLayoutY(location.getY()-image.getBoundsInParent().getHeight()/2);
    }

    public Node getImage () {
        return image;
    }

    public void setImage (Node newImage) {
        image = newImage;
    }
    public boolean getPenDownStatus() {
        return penDown;
    }
    public void setPenDownStatus(boolean newStatus) {
        penDown = newStatus;
    }
}
