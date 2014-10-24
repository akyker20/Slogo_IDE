package gui.turtlescreenwrap;


/**
 * Class converts coordinates from typical javafx grid ones to cartesian 2D with origin
 * at center of screen, increasing y upwards and increasing x to right
 * @author allankiplagat
 *
 */
public class CoordinateChanger {
    public static final float SCREEN_WIDTH = TurtleScreenWrap.XMAX*2;
    public static final float SCREEN_HEIGHT = TurtleScreenWrap.YMAX*2;  
    
    public static float convX(float x) {
        x = x + SCREEN_WIDTH/2;
        return x;
    }
    public static float convY(float y) {
        y =  SCREEN_HEIGHT/2 - y;
        return y;
    }
}
