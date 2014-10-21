package gui.turtlescreenwrap;


import static org.junit.Assert.*;
import java.util.List;
import gui.componentdrawers.TurtleScreenDrawer;
import org.junit.Test;
import com.sun.javafx.geom.Point2D;

public class TurtleScreenWrapTests {
    public static final float XMAX = TurtleScreenWrap.SCREEN_WIDTH/2;
    public static final float YMAX = TurtleScreenWrap.SCREEN_HEIGHT/2;
    @Test
    public void exitTopRightDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX/2,YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<0.00001);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<0.00001);
        assertTrue(Math.abs(list.get(0).dest.x-XMAX/4)<0.00001);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX)<0.00001);
        
        assertTrue(Math.abs(list.get(1).origin.x-XMAX/4)<0.00001);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX))<0.00001);
        
        assertTrue(Math.abs(list.get(1).dest.x-XMAX/2)<0.00001);
        assertTrue(Math.abs(list.get(1).dest.y)<0.00001);
    }
    @Test
    public void exitTopLeftDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX/2,YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<0.00001);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<0.00001);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX/4))<0.00001);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX)<0.00001);
        
        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX/4))<0.00001);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX))<0.00001);
        
        assertTrue(Math.abs(list.get(1).dest.x-(-XMAX/2))<0.00001);
        assertTrue(Math.abs(list.get(1).dest.y)<0.00001);     
    }
    
    @Test
    public void exitBottomRightDiagonally() {
        
    }
    
    
    
}
