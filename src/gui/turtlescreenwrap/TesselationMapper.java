package gui.turtlescreenwrap;

import com.sun.javafx.geom.Point2D;



public class TesselationMapper {
    public static final float XMAX = TurtleScreenWrap.XMAX;
    public static final float YMAX = TurtleScreenWrap.YMAX;

    /**
     * Method returns a mapped tesselated pair, based on the origin of the point2DPair
     * @param point
     * @return
     */
    public static Point2DPair map (Point2DPair pointPair) {
        //if origin point is on-screen, no mapping to be done
        if (!TurtleScreenWrap.checkOffScreen(pointPair.origin))
            return pointPair;
        
        Point2D dummyOrigin = getDummyOrigin(pointPair.origin);
        
        pointPair.origin.x = pointPair.origin.x-dummyOrigin.x;
        pointPair.origin.y = pointPair.origin.y-dummyOrigin.y;
        pointPair.dest.x = pointPair.dest.x-dummyOrigin.x;
        pointPair.dest.y = pointPair.dest.y-dummyOrigin.y;
        
        return pointPair;
    }

    /**
     * Method returns a mapped Point2D
     * @param point
     * @return
     */
    public static Point2D map (Point2D point) {
        if (!TurtleScreenWrap.checkOffScreen(point))
            return point;
        Point2D dummyOrigin = getDummyOrigin(point);
        
        point.x = point.x-dummyOrigin.x;
        point.y = point.y-dummyOrigin.y;
        return point;
    }
    
    
    /**
     * Method gets dummy origin for point's tesselated screen 
     * @return
     */
    public static Point2D getDummyOrigin (Point2D point) {

        float xsign = Math.signum(point.x);
        float ysign = Math.signum(point.y);

        float xabs = Math.abs(point.x)-XMAX;
        float yabs = Math.abs(point.y)-YMAX;

        int xcount = Math.floorDiv( (int) xabs, (int) XMAX*2);
        int ycount = Math.floorDiv( (int) yabs, (int) YMAX*2);

        //dummy origin
        float dummyX = xsign*(XMAX*2)*(xcount+1);
        float dummyY = ysign*(YMAX*2)*(ycount+1);
        
        return new Point2D(dummyX,dummyY);
    }
}
