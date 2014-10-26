package gui.turtlescreenwrap;

import java.util.ArrayList;
import java.util.List;
import com.sun.javafx.geom.Point2D;

/**
 * Class handles screen wrapping when the turtle is moving horizontally
 * @author allankiplagat
 *
 */
public class HorizontalTurtleScreenWrap {
    public static List<Point2DPair> fragmentPoint2DPair (Point2DPair pointPair) {
        List<Point2DPair> fragments = new ArrayList<Point2DPair>();

        // base case: destination on-screen
        if (!TesselationMapper.checkOffScreen(pointPair.dest)) {
            fragments.add(pointPair);
            return fragments;
        }

        Point2D destA = new Point2D();
        Point2D originB = new Point2D();
        Point2D destB = new Point2D();

        String direction = TurtleScreenWrap.getXmovement(pointPair);

        float y = pointPair.origin.y;
        destA.y = y;
        originB.y = y;
        destB.y = y;

        if (direction.equals(TurtleScreenWrap.XPOS_MOVE)) {
            destA.x = TurtleScreenWrap.XMAX;
            originB.x = -TurtleScreenWrap.XMAX;
            destB.x = -TurtleScreenWrap.XMAX +
                    ((pointPair.dest.x - pointPair.origin.x)
                            - (TurtleScreenWrap.XMAX - pointPair.origin.x));
        }
        else {
            destA.x = -TurtleScreenWrap.XMAX;
            originB.x = TurtleScreenWrap.XMAX;
            destB.x = TurtleScreenWrap.XMAX -
                    ((pointPair.origin.x - pointPair.dest.x)
                            - (pointPair.origin.x - (-TurtleScreenWrap.XMAX)));
        }
        fragments.add(new Point2DPair(pointPair.origin, destA));
        // recurse
        List<Point2DPair> newfragments = fragmentPoint2DPair(new Point2DPair(originB, destB));
        // combine
        for (Point2DPair fragment : newfragments) {
            fragments.add(fragment);
        }
        return fragments;
    }
}
