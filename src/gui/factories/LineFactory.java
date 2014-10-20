package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Node[] generateObject (Map<String, String> params) {
        List<Line> linesList = generateLines(params);
        Line[] lines = new Line[linesList.size()];
        for (int k=0;k<linesList.size();k++) {
            lines[k] = linesList.get(k);
        }
        
        return lines;
    }

    public List<Line> generateLines (Map<String, String> params) {
        List<Line> lineList = new ArrayList<Line>();

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
                double newDestY = origin[1]+deltaY;

                //exited top/bottom so start bottom/top
                if (movingUp) {
                    recurseOrigin = new double[]{origin[0],-TurtleScreenDrawer.GRID_HEIGHT/2};
                    recurseDestination = new double[]{origin[0],
                                                      -TurtleScreenDrawer.GRID_HEIGHT/2+((destination[1]-origin[1])-deltaY)};
                } else {
                    recurseOrigin = new double[]{origin[0],TurtleScreenDrawer.GRID_HEIGHT/2};
                    recurseDestination = new double[]{origin[0],TurtleScreenDrawer.GRID_HEIGHT/2-
                                                      ((origin[1]-destination[1])-(origin[1]-newDestY))};
                }
                destination[1] = newDestY;

            } else {
                //if exiting through y, use deltaY else use deltaX
                if (exitY) {
                    double newDestY = origin[1]+deltaY;
                    double newDestX = origin[0]+deltaY/gradient;
                    double remainderDeltaY = destination[1]-origin[1]-deltaY;

                    //exited top/bottom so start bottom/top
                    if (movingUp) {
                        recurseOrigin = new double[]{newDestX,-TurtleScreenDrawer.GRID_HEIGHT/2};                     
                        recurseDestination = new double[]{recurseOrigin[0]+remainderDeltaY/gradient,
                                                          recurseOrigin[1]+remainderDeltaY};

                    } else {
                        recurseOrigin = new double[]{newDestX,TurtleScreenDrawer.GRID_HEIGHT/2};
                        recurseDestination = new double[]{recurseOrigin[0]+remainderDeltaY/gradient,
                                                          recurseOrigin[1]+remainderDeltaY};

                    }

                    destination[1] = newDestY;
                    destination[0] = newDestX;

                    //exiting through x so use delta x    
                } else {
                    double newDestY = origin[1]+deltaX*gradient;
                    double newDestX = origin[0]+deltaX;
                    double remainderDeltaX = destination[0]-origin[0]-deltaX;

                    //exited left/right so start right/left
                    if (movingRight) {
                        recurseOrigin = new double[]{-TurtleScreenDrawer.GRID_WIDTH/2,newDestY};
                        recurseDestination = new double[]{recurseOrigin[0]+remainderDeltaX,
                                                          recurseOrigin[1]+remainderDeltaX*gradient};
                    } else {
                        recurseOrigin = new double[]{TurtleScreenDrawer.GRID_WIDTH/2,newDestY};
                        recurseDestination = new double[]{recurseOrigin[0]+remainderDeltaX,
                                                          recurseOrigin[1]+remainderDeltaX*gradient};
                    }

                    destination[1] = newDestY;
                    destination[0] = newDestX;
                }
            }

            line.setEndX(TurtleScreenDrawer.GRID_WIDTH/2 + destination[0] );
            line.setEndY(TurtleScreenDrawer.GRID_HEIGHT/2 - destination[1]);
            
            //make recursive call
            Map<String,String> recursiveParams = new HashMap<String,String>();
            recursiveParams.put(ORIGIN,recurseOrigin[0]+" "+recurseOrigin[1]);
            recursiveParams.put(DESTINATION, recurseDestination[0]+" "+recurseDestination[1]);
            //add returned lines to list
            List<Line> otherLines = this.generateLines(recursiveParams);
            for (Line otherLine:otherLines) {
                lineList.add(otherLine);
            }         

        } else {
            line.setEndX(TurtleScreenDrawer.GRID_WIDTH/2 + destination[0] );
            line.setEndY(TurtleScreenDrawer.GRID_HEIGHT/2 - destination[1]);
        }
        //destination = GridEdgeRules.applyRules(origin, destination);
        //add current list to lineList
        lineList.add(line);
        return lineList;
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
