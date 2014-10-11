package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.GridDrawer;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TurtleFactory extends ObjectFactory {
    
    public static final String PARENT = ComponentInitializer.GRID_DRAWER;
    public static final String TYPE = FactoryInitializer.TURTLE_FACTORY;
    public static final String HEADING = "heading";
    public static final String LOCATION = "location";
    public static final String OPACITY = "opacity";
    
    private static final String DEFAULT_TURTLE_IMAGEPATH = "turtle_image.png";
    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.05;
    private static final double TURTLE_IMAGE_WIDTH = GridDrawer.GRID_WIDTH *
                                                    TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.1;
    private static final double TURTLE_IMAGE_HEIGHT = GridDrawer.GRID_HEIGHT *
                                                     TURTLE_IMAGE_HEIGHT_RATIO;
    
    private Node myImageView;

    public TurtleFactory (String name) {
        super(name);
       Image image =
                new Image(getClass().getResourceAsStream(DEFAULT_TURTLE_IMAGEPATH),
                          TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                          false, true);
        myImageView = new ImageView(image);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        double[] newLocation = parseStringToPoints(params.get(LOCATION));
        myImageView.setLayoutX(newLocation[0] + GridDrawer.GRID_WIDTH/2 - TURTLE_IMAGE_WIDTH/2);
        myImageView.setLayoutY(- newLocation[1] + GridDrawer.GRID_HEIGHT/2 - TURTLE_IMAGE_HEIGHT/2);
        myImageView.setRotate(Double.parseDouble(params.get(HEADING)));
        myImageView.setOpacity(Double.parseDouble(params.get(OPACITY)));
        return myImageView;
    }

    private double[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");

        double[] parsedPoint = new double[]{Double.parseDouble(splitPoint[0]),
                                            Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }
}
