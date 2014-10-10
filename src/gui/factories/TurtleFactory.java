package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.GridDrawer;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.image.Image;


public class TurtleFactory extends ObjectFactory {
    
    public static final String PARENT = ComponentInitializer.GRID_DRAWER;
    public static final String TYPE = FactoryInitializer.TURTLE_FACTORY;
    public static final String HEADING = "heading";
    public static final String LOCATION = "location";
    
    private static final String DEFAULT_TURTLE_IMAGEPATH = "turtle_image.png";
    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.05;
    private static final double TURTLE_IMAGE_WIDTH = GridDrawer.GRID_WIDTH *
                                                    TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.1;
    private static final double TURTLE_IMAGE_HEIGHT = GridDrawer.GRID_HEIGHT *
                                                     TURTLE_IMAGE_HEIGHT_RATIO;
    
    private Image myImage;

    public TurtleFactory (String name) {
        super(name);
        myImage =
                new Image(getClass().getResourceAsStream(DEFAULT_TURTLE_IMAGEPATH),
                          TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                          false, true);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
//        Turtle turtle = new Turtle();

//        return turtle.getImage();
        return null;
        
//        // TODO: might use binding to achieve this layout and location coupling later
//        //using offset to have placement relative to image center
//        image.setLayoutX(location.getX()-image.getBoundsInParent().getWidth()/2);
//        image.setLayoutY(location.getY()-image.getBoundsInParent().getHeight()/2);
//    }
    }
}
