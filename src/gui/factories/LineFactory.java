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

            boolean vertical = (destination[0]==origin[0]);
            double gradient = (destination[1]-origin[1])/(destination[0]-origin[0]);

            double deltaX = 0.0;
            double deltaY = 0.0;

            boolean movingRight = true;
            //if moving to right, set deltaX to distance from right edge
            if (destination[0]>origin[0]) {      
                deltaX= TurtleScreenDrawer.GRID_WIDTH/2-origin[0];
            } else if  (destination[0]<origin[0]) {
                deltaX = -(origin[0]-(-TurtleScreenDrawer.GRID_WIDTH/2));
                movingRight = false;
            }

            boolean movingUp = true;
            //if moving up, set deltaY to distance from top edge
            if (destination[1]>origin[1]) {      
                deltaY= TurtleScreenDrawer.GRID_HEIGHT/2-origin[1];
            } else if (destination[1]<origin[1]) {
                deltaY = -(origin[1]-(-TurtleScreenDrawer.GRID_HEIGHT/2));
                movingUp = false;
            }

            //determine whether line exits screen through x edge or y edge            
            boolean exitY = true;
            double[] tempDestination;

            if (!vertical) {
                //if exit is through y edge, using deltaX will yield off-screen destination
                tempDestination = new double[]{origin[0]+deltaX,origin[1]+gradient*deltaX};
                exitY = destinationOffScreen(tempDestination);
            } 

            //determine new destination & the recursing origin-destination set
            double[] recurseOrigin,recurseDestination;

            //if moving vertically, use deltaY, keep x ordinate 
            if (vertical) {
                double newY = origin[1]+deltaY;

                //exited top/bottom so start bottom/top
                if (movingUp) {
                    recurseOrigin = new double[]{origin[0],-TurtleScreenDrawer.GRID_HEIGHT/2};
                    recurseDestination = new double[]{origin[0],
                                          -TurtleScreenDrawer.GRID_HEIGHT/2+((destination[1]-origin[1])-deltaY)};
                } else {
                    recurseOrigin = new double[]{origin[0],TurtleScreenDrawer.GRID_HEIGHT/2};
                    recurseDestination = new double[]{origin[0],TurtleScreenDrawer.GRID_HEIGHT/2-
                                                      ((origin[1]-destination[1])-(origin[1]-newY))};
                }
                destination[1] = newY;
     
            } else {
                //if exiting through y, use deltaY else use deltaX
                if (exitY) {
                    destination[1] = origin[1]+deltaY;
                    destination[0] = origin[0]+deltaY/gradient;
                } else {
                    destination[0] = origin[0]+deltaX;
                    destination[1] = origin[1]+deltaX*gradient;
                }
            }


            line.setEndX(TurtleScreenDrawer.GRID_WIDTH/2 + destination[0] );
            line.setEndY(TurtleScreenDrawer.GRID_HEIGHT/2 - destination[1]);
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
