package gui.turtlescreenwrap.tests;


import static org.junit.Assert.*;
import java.util.List;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.turtlescreenwrap.Point2DPair;
import gui.turtlescreenwrap.TurtleScreenWrap;
import org.junit.Test;
import com.sun.javafx.geom.Point2D;

public class TurtleScreenWrapTests {
    public static final float XMAX = TurtleScreenWrap.XMAX;
    public static final float YMAX = TurtleScreenWrap.YMAX;
    public static final double THRESH = 0.00001;
    @Test
    public void exitTopRightDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX/2,YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-XMAX/4)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-XMAX/4)<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x-XMAX/2)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);
    }
    @Test
    public void exitTopLeftDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX/2,YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX))<THRESH);

        assertTrue(Math.abs(list.get(1).dest.x-(-XMAX/2))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);     
    }

    @Test
    public void exitBottomRightDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX/2,-YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-XMAX/4)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-(-YMAX))<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-XMAX/4)<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(YMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x-XMAX/2)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);
    }

    @Test
    public void exitBottomLeftDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX/2,-YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        //        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-(-YMAX))<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(YMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x-(-XMAX/2))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);
    }  

    @Test
    public void exitRightTopDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX*2,YMAX/2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-XMAX)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX/4)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(YMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y-(YMAX/2))<THRESH);
    }

    @Test
    public void exitRightBOttomDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX*2,-YMAX/2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-XMAX)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-(-YMAX/4))<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y-(-YMAX/2))<THRESH);
    }

    @Test
    public void exitLeftTopDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX*2,YMAX/2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX/4)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(XMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(YMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y-(YMAX/2))<THRESH);
    }

    @Test
    public void exitLeftBottomDiagonally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX*2,-YMAX/2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-(-YMAX/4))<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(XMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX/4))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y-(-YMAX/2))<THRESH);
    } 

    @Test
    public void exitRightHorizontally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(XMAX*2,0);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(XMAX))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);       
    }

    @Test 
    public void exitLeftHorizontally() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(-XMAX*2,0);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x-(-XMAX))<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x-XMAX)<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);       
    }  

    @Test
    public void exitTopVertically() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(0,YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-YMAX)<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x)<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(-YMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);       
    }  

    @Test
    public void exitBottomVertically() {
        Point2D origin = new Point2D(0,0);
        Point2D dest = new Point2D(0,-YMAX*2);
        List<Point2DPair> list = TurtleScreenWrap.fragmentPoint2DPair(new Point2DPair(origin,dest));
        assertTrue(list.size()==2);

        assertTrue(Math.abs(list.get(0).origin.x-origin.x)<THRESH);
        assertTrue(Math.abs(list.get(0).origin.y-origin.y)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(0).dest.y-(-YMAX))<THRESH);

        assertTrue(Math.abs(list.get(1).origin.x)<THRESH);
        assertTrue(Math.abs(list.get(1).origin.y-(YMAX))<THRESH);
        assertTrue(Math.abs(list.get(1).dest.x)<THRESH);
        assertTrue(Math.abs(list.get(1).dest.y)<THRESH);       
    }  
}
