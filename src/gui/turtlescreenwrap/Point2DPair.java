package gui.turtlescreenwrap;

import com.sun.javafx.geom.Point2D;

/**
 * Class represents a Point2D tuple of a starting and ending point
 * @author allankiplagat
 *
 */
public class Point2DPair {
    public Point2D origin;
    public Point2D dest;

    public Point2DPair (Point2D origin, Point2D destination) {
        super();
        this.origin = origin;
        dest = destination;
    }

}
