package gui.turtlescreenwrap;

import java.util.ArrayList;
import java.util.List;
import com.sun.javafx.geom.Point2D;


public class VerticalTurtleScreenWrap {
    public static List<Point2DPair> fragmentPoint2DPair (Point2DPair pointPair) {
        List<Point2DPair> fragments = new ArrayList<Point2DPair>();
        // base case: destination is on-screen
        if (!TesselationMapper.checkOffScreen(pointPair.dest)) {
            fragments.add(pointPair);
            return fragments;
        }

        Point2D destA = new Point2D();
        Point2D originB = new Point2D();
        Point2D destB = new Point2D();

        String direction = TurtleScreenWrap.getYmovement(pointPair);

        float x = pointPair.origin.x;
        destA.x = x;
        originB.x = x;
        destB.x = x;

        if (direction.equals(TurtleScreenWrap.YPOS_MOVE)) {
            destA.y = TurtleScreenWrap.YMAX;
            originB.y = -TurtleScreenWrap.YMAX;
            destB.y = -TurtleScreenWrap.YMAX +
                    ((pointPair.dest.y - pointPair.origin.y)
                            - (TurtleScreenWrap.YMAX - pointPair.origin.y));
            /*
             * destB.y = -TurtleScreenWrap.YMAX+
             * pointPair.dest.y-(destA.y-pointPair.origin.y);
             */

        }
        else {
            destA.y = -TurtleScreenWrap.YMAX;
            originB.y = TurtleScreenWrap.YMAX;
            destB.y = TurtleScreenWrap.YMAX -
                    ((pointPair.origin.y - pointPair.dest.y)
                            - (pointPair.origin.y - (-TurtleScreenWrap.YMAX)));
        }

        fragments.add(new Point2DPair(pointPair.origin, destA));
        // recurse
        List<Point2DPair> newfragments = fragmentPoint2DPair(new Point2DPair(originB, destB));
        ;
        // combine
        for (Point2DPair fragment : newfragments) {
            fragments.add(fragment);
        }
        return fragments;
    }
}
