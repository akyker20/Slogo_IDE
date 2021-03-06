package gui.turtlescreenwrap;

import gui.componentdrawers.TurtleScreenDrawer;
import java.util.ArrayList;
import java.util.List;
import com.sun.javafx.geom.Point2D;

/**
 * Class applies wrapping around algorithm to a Point2DPair object
 * @author allankiplagat
 *
 */
public class TurtleScreenWrap {
    public static final float XMAX = (float) TurtleScreenDrawer.GRID_WIDTH / 2;
    public static final float YMAX = (float) TurtleScreenDrawer.GRID_HEIGHT / 2;

    public static final String XPOS_MOVE = "XPositive move";
    public static final String XNEG_MOVE = "XNegative move";
    public static final String XZERO_MOVE = "XZero move";
    public static final String YPOS_MOVE = "YPositive move";
    public static final String YNEG_MOVE = "YNegative move";
    public static final String YZERO_MOVE = "YZero move";

    public static final String TOP_EDGE = "TopEdge";
    public static final String BOTTOM_EDGE = "BottomEdge";
    public static final String LEFT_EDGE = "LeftEdge";
    public static final String RIGHT_EDGE = "RightEdge";

    /**
     * Method takes in a Point2DPair (that contains an origin and destination Point2D) and returns
     * the corresponding sequence of sub-Point2DPairs to be displayed on the screen with wrap-around
     * applied
     *
     * @param pointPair
     * @return
     */
    public static List<Point2DPair> fragmentPoint2DPair (Point2DPair tesselatedPointPair) {
        Point2DPair pointPair = TesselationMapper.map(tesselatedPointPair);

        List<Point2DPair> pointPairsList = new ArrayList<Point2DPair>();
        // base case: destination is on-screen
        if (!TesselationMapper.checkOffScreen(pointPair.dest)) {
            pointPairsList.add(pointPair);
            return pointPairsList;
        }

        // points aligned vertically
        if (pointPair.origin.x == pointPair.dest.x) { return VerticalTurtleScreenWrap
                .fragmentPoint2DPair(pointPair); }

        // points aligned horizontally
        if (pointPair.origin.y == pointPair.dest.y) { return HorizontalTurtleScreenWrap
                .fragmentPoint2DPair(pointPair); }

        float gradient = getGradient(pointPair);

        String xmovement = getXmovement(pointPair);
        String ymovement = getYmovement(pointPair);

        float maxDeltaX = getMaxDeltaX(pointPair, xmovement);
        float maxDeltaY = getMaxDeltaY(pointPair, ymovement);

        String exitEdge = getExitEdge(pointPair, gradient, maxDeltaY,
                                      xmovement, ymovement);

        List<Point2DPair> fragments = getFragments(pointPair, exitEdge,
                                                   gradient, maxDeltaX, maxDeltaY);
        // recurse
        List<Point2DPair> newfragments = fragmentPoint2DPair(fragments.get(1));
        // combine
        List<Point2DPair> list = new ArrayList<Point2DPair>();
        list.add(fragments.get(0));
        for (Point2DPair fragment : newfragments) {
            list.add(fragment);
        }
        return list;
    }

    public static List<Point2DPair> getFragments (Point2DPair pointPair, String exitEdge,
                                                  float gradient, float maxDeltaX, float maxDeltaY) {
        Point2D destA = new Point2D();
        Point2D originB = new Point2D();
        Point2D destB = new Point2D();

        if (exitEdge.equals(TOP_EDGE) || exitEdge.equals(BOTTOM_EDGE)) {
            // use maxDeltaY
            destA.x = pointPair.origin.x + maxDeltaY / gradient;
            destA.y = pointPair.origin.y + maxDeltaY;
            // set fragment B
            originB.x = destA.x;
            originB.y = -destA.y;
            destB.x = originB.x + (pointPair.dest.x - pointPair.origin.x) - maxDeltaY / gradient;
            destB.y = originB.y + (pointPair.dest.y - pointPair.origin.y) - maxDeltaY;
        }
        else {
            // use maxDeltaX
            destA.x = pointPair.origin.x + maxDeltaX;
            destA.y = pointPair.origin.y + maxDeltaX * gradient;
            // set fragment B
            originB.x = -destA.x;
            originB.y = destA.y;
            destB.x = originB.x + (pointPair.dest.x - pointPair.origin.x) - maxDeltaX;
            destB.y = originB.y + (pointPair.dest.y - pointPair.origin.y) - maxDeltaX * gradient;
        }

        List<Point2DPair> fragments = new ArrayList<Point2DPair>();
        fragments.add(new Point2DPair(pointPair.origin, destA));
        fragments.add(new Point2DPair(originB, destB));

        return fragments;
    }

    public static String getExitEdge (Point2DPair pointPair, float gradient,
                                      float maxDeltaY, String xmovement, String ymovement) {
        // if exit through left/right edge, using maxDeltaY yields off-screen point
        // IMPORTANT: converting to int for truncation. Otherwise running decimals may result in
        // incorrect checkOffScreen result
        int x = (int) (pointPair.origin.x + maxDeltaY / gradient);
        int y = (int) (pointPair.origin.y + maxDeltaY);

        Point2D tempDest = new Point2D(x, y);

        if (TesselationMapper.checkOffScreen(tempDest)) {
            // exit is through left/right edge
            if (xmovement.equals(XPOS_MOVE)) {
                return RIGHT_EDGE;
            }
            else {
                return LEFT_EDGE;
            }
        }
        else {
            // exit is through top/bottom edge
            if (ymovement.equals(YPOS_MOVE)) {
                return TOP_EDGE;
            }
            else {
                return BOTTOM_EDGE;
            }
        }
    }

    public static float getMaxDeltaY (Point2DPair pointPair, String ymovement) {
        if (ymovement.equals(YPOS_MOVE)) {
            return YMAX - pointPair.origin.y;
        }
        else if (ymovement.equals(YNEG_MOVE)) { return -YMAX - pointPair.origin.y; }
        return 0;
    }

    public static float getMaxDeltaX (Point2DPair pointPair, String xmovement) {
        if (xmovement.equals(XPOS_MOVE)) {
            return XMAX - pointPair.origin.x;
        }
        else if (xmovement.equals(XNEG_MOVE)) { return -XMAX - pointPair.origin.x; }
        return 0;
    }

    public static String getYmovement (Point2DPair pointPair) {
        if (pointPair.dest.y > pointPair.origin.y) {
            return YPOS_MOVE;
        }
        else if (pointPair.dest.y < pointPair.origin.y) { return YNEG_MOVE; }
        // won't happen, would've already been delegated to horizontalscreenwrap
        return YZERO_MOVE;
    }

    public static String getXmovement (Point2DPair pointPair) {
        if (pointPair.dest.x > pointPair.origin.x) {
            return XPOS_MOVE;
        }
        else if (pointPair.dest.x < pointPair.origin.x) { return XNEG_MOVE; }
        // won't happen, would've already been delegated to verticalscreenwrap
        return XZERO_MOVE;

    }

    /**
     * Method gets the gradient of the line joining the points in a pointPair
     * Returns 0.0 if the line is vertical (infinite gradient)
     *
     * @param pointPair
     * @param isVerticalLine
     * @return
     */
    public static float getGradient (Point2DPair pointPair) {
        return (pointPair.dest.y - pointPair.origin.y) /
                (pointPair.dest.x - pointPair.origin.x);
    }

}
