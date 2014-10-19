package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;

import java.util.HashMap;
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
    public static final String TURTLE_IMAGE_ID = "turtleImageID";

    private static final String DEFAULT_TURTLE_IMAGEPATH = "turtle_image.png";
    private static final double TURTLE_IMAGE_WIDTH_RATIO = 0.05;
    private static final double TURTLE_IMAGE_WIDTH = TurtleScreenDrawer.GRID_WIDTH *
            TURTLE_IMAGE_WIDTH_RATIO;
    private static final double TURTLE_IMAGE_HEIGHT_RATIO = 0.1;
    private static final double TURTLE_IMAGE_HEIGHT = TurtleScreenDrawer.GRID_HEIGHT *
            TURTLE_IMAGE_HEIGHT_RATIO;

    
    
    private static Map<String,Node> myTurtleViews;

    public TurtleFactory (String name) {
        super(name);
        myTurtleViews = new HashMap<String,Node>();
        System.out.println(myTurtleViews);

    }

    @Override
    public Node generateObject (Map<String, String> params) {
        String turtleID = params.get(TURTLE_IMAGE_ID);
        if (myTurtleViews.containsKey(turtleID)) {
            System.out.println("TurtleFactory: turtle in views\n");
            return updateTurtleImage(params);           
        } else {
            System.out.println("TurtleFactory: turtle not views\n");
            return createTurtleImage(params);
        }
       
    }

    private Node createTurtleImage(Map<String, String> params) {      
        Image image =
                new Image(getClass().getResourceAsStream(DEFAULT_TURTLE_IMAGEPATH),
                          TURTLE_IMAGE_WIDTH, TURTLE_IMAGE_HEIGHT,
                          false, true);
        ImageView imageView = new ImageView(image);
        myTurtleViews.put(params.get(TURTLE_IMAGE_ID), imageView);
        updateTurtleImage(params);
        return imageView;
    }

    private Node updateTurtleImage(Map<String, String> params) {

        Node currentImageView = myTurtleViews.get(params.get(TURTLE_IMAGE_ID));

        
        double[] origin = new double[]{currentImageView.getLayoutX() - TurtleScreenDrawer.GRID_WIDTH/2 + TURTLE_IMAGE_WIDTH/2,
        		currentImageView.getLayoutY() - TurtleScreenDrawer.GRID_HEIGHT/2 + TURTLE_IMAGE_HEIGHT/2};
        double[] newLocation = parseStringToPoints(params.get(LOCATION));

        newLocation = GridEdgeRules.applyRules(origin,newLocation);
        
        currentImageView.setLayoutX(newLocation[0] + TurtleScreenDrawer.GRID_WIDTH/2 - TURTLE_IMAGE_WIDTH/2);
        currentImageView.setLayoutY(- newLocation[1] + TurtleScreenDrawer.GRID_HEIGHT/2 - TURTLE_IMAGE_HEIGHT/2);
        
        currentImageView.setRotate(Double.parseDouble(params.get(HEADING)));
        currentImageView.setOpacity(Double.parseDouble(params.get(OPACITY)));  
        return new NullNode();
    }

    public static void clearTurtleViews() {
        myTurtleViews.clear();
    }

    private double[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");

        double[] parsedPoint = new double[]{Double.parseDouble(splitPoint[0]),
                                            Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }
}
