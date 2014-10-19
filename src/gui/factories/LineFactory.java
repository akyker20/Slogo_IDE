package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;

import java.util.Map;

import javafx.scene.Node;
import javafx.scene.shape.Line;


public class LineFactory extends ObjectFactory {

    public static final String ORIGIN = "origin";
    public static final String DESTINATION = "destination";
    public static final String PARENT = ComponentInitializer.GRID_DRAWER;
    public static final String TYPE = FactoryInitializer.LINE_FACTORY;

    public LineFactory (String name) {
        super(name);
    }

    @Override

    public Node generateObject (Map<String, String> params) {

        Line line = new Line();
        double[] origin = parseStringToPoints(params.get(ORIGIN));
        double[] destination = parseStringToPoints(params.get(DESTINATION));  

        line.setStartX(TurtleScreenDrawer.GRID_WIDTH/2 + origin[0] );
        line.setStartY(TurtleScreenDrawer.GRID_HEIGHT/2 - origin[1]);

        if (destinationOffScreen(destination)) {
            //determine new destination 
            //make recursive call
        } else {
            line.setEndX(TurtleScreenDrawer.GRID_WIDTH/2 + destination[0] );
            line.setEndY(TurtleScreenDrawer.GRID_HEIGHT/2 - destination[1]);
        }
        //destination = GridEdgeRules.applyRules(origin, destination);
        return line;
    }

    private boolean destinationOffScreen(double[] destination) {
        boolean isOffScreen = (
                destination[0]>TurtleScreenDrawer.GRID_WIDTH/2  ||
                destination[0]<-TurtleScreenDrawer.GRID_WIDTH/2 ||
                destination[1]>TurtleScreenDrawer.GRID_HEIGHT/2 ||
                destination[1]<-TurtleScreenDrawer.GRID_HEIGHT/2
                );
        return isOffScreen;
    }

    /**
     * Breaks a string representing a location into an array of points.
     * The first element in the array is the x coordinate of the location
     * and the second element in the array is the y coordinate of the location.
     * @param point
     * @return
     */
    private double[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");

        double[] parsedPoint = new double[]{Double.parseDouble(splitPoint[0]),
                                            Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }

}
