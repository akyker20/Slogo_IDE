package tests.screenWrapTests;

import static org.junit.Assert.assertFalse;
import gui.turtlescreenwrap.TesselationMapper;
import java.util.Random;
import org.junit.Test;
import com.sun.javafx.geom.Point2D;


public class MapperRandomPointTests {

    Random randx = new Random();
    Random randy = new Random();

    @Test
    public void testRandom () {
        for (int k = 0; k < 10; k++) {
            Point2D point = new Point2D(700 + randx.nextFloat(), 840 + randy.nextFloat());
            Point2D mappedpoint = TesselationMapper.map(point);
            assertFalse(TesselationMapper.checkOffScreen(mappedpoint));
        }
    }
}
