package gui.turtlescreenwrap.tests;

import static org.junit.Assert.*;
import gui.turtlescreenwrap.Point2DPair;
import gui.turtlescreenwrap.TesselationMapper;
import gui.turtlescreenwrap.TurtleScreenWrap;
import org.junit.Test;
import com.sun.javafx.geom.Point2D;

public class TesselationMapperTests {
    public static final float XMAX = TurtleScreenWrap.XMAX;
    public static final float YMAX = TurtleScreenWrap.YMAX;
    public static final double THRESH = 0.00001;

    //for current tests, origin needs to be within home screen
    private float origx = -XMAX/2;
    private float origy = -XMAX/2;
    
    private float destx = -XMAX*2;
    private float desty = -YMAX*2;

    @Test
    public void testHomeScreen() {
        Point2DPair pointPair = new Point2DPair(new Point2D(origx,origy),new Point2D(destx,desty));
        Point2DPair newPair = TesselationMapper.map(pointPair);
        assertTrue(pointPair.equals(newPair));
    }

    @Test
    public void testRightScreen() {
        test(new Point2D(origx+XMAX*2,origy),
             new Point2D(destx+XMAX*2,desty));
    }

    @Test
    public void testTopRightDiagonalScreen() {
        test(new Point2D(origx+XMAX*2,origy+YMAX*2),
             new Point2D(destx+XMAX*2,desty+YMAX*2));
    }

    @Test
    public void testTopScreen() {
        test(new Point2D(origx+XMAX*2,origy+YMAX*2),
             new Point2D(destx+XMAX*2,desty+YMAX*2));
    }
    
    @Test
    public void testTopLeftDiagonalScreen() {
        test(new Point2D(origx-XMAX*2,origy+YMAX*2),
             new Point2D(destx-XMAX*2,desty+YMAX*2));        
    }
    
    @Test
    public void testLeftScreen() {
        test(new Point2D(origx-XMAX*2,origy),
             new Point2D(destx-XMAX*2,desty));        
    }
    
    @Test
    public void testBottomLeftDiagonalScreen() {
        test(new Point2D(origx-XMAX*2,origy-YMAX*2),
             new Point2D(destx-XMAX*2,desty-YMAX*2));        
    }
    
    @Test
    public void testBottomScreen() {
        test(new Point2D(origx,origy-YMAX*2),
             new Point2D(destx,desty-YMAX*2));        
    }

    @Test
    public void testBottomRightDiagonalScreen() {
        test(new Point2D(origx+XMAX*2,origy-YMAX*2),
             new Point2D(destx+XMAX*2,desty-YMAX*2));        
    }   
    
    private void test(Point2D origin,Point2D dest) {
        Point2DPair pointPair = new Point2DPair(origin,dest);
        testDiagonal(pointPair);
    } 

    private void testDiagonal(Point2DPair pointPair) {
        Point2DPair pair = TesselationMapper.map(pointPair);
        assertTrue(Math.abs(pair.origin.x-origx)<THRESH); 
        assertTrue(Math.abs(pair.origin.y-origy)<THRESH);
        assertTrue(Math.abs(pair.dest.x-destx)<THRESH);
        assertTrue(Math.abs(pair.dest.y-desty)<THRESH);
    }
}
