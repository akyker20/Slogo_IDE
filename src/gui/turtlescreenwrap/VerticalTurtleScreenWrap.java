package gui.turtlescreenwrap;

import java.util.ArrayList;
import java.util.List;
import com.sun.javafx.geom.Point2D;

public class VerticalTurtleScreenWrap  {
    public static List<Point2DPair> fragmentPoint2DPair(Point2DPair pointPair) { 
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
            destB.y = -TurtleScreenWrap.YMAX+
                    ((pointPair.dest.y-pointPair.origin.y)
                    -(TurtleScreenWrap.YMAX-pointPair.origin.y));
        } else {
            destA.y = -TurtleScreenWrap.YMAX;
            originB.y = TurtleScreenWrap.YMAX;
            destB.y = TurtleScreenWrap.YMAX-
                    ((pointPair.origin.y-pointPair.dest.y)
                    -(pointPair.origin.y-(-TurtleScreenWrap.YMAX)));
        }
        
        List<Point2DPair> fragments = new ArrayList<Point2DPair>();
        fragments.add(new Point2DPair(pointPair.origin,destA));
        fragments.add(new Point2DPair(originB,destB));
        return fragments;
    }
}
