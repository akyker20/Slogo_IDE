package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.turtlescreenwrap.Point2DPair;
import gui.turtlescreenwrap.TurtleScreenWrapAround;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sun.javafx.geom.Point2D;
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
        

        Point2D origin = parseStringToPoints(params.get(ORIGIN));
        Point2D dest = parseStringToPoints(params.get(DESTINATION));
        //split into 'sub-lines'
        List<Point2DPair> pointPairs = TurtleScreenWrapAround.
                fragmentPoint2DPair(new Point2DPair(origin,dest));
        
        List<Line> lineList = new ArrayList<Line>();
        for (Point2DPair pointPair:pointPairs) {
            Line line = new Line();
            line.setStartX(pointPair.origin.x);
            line.setStartY(pointPair.origin.y);
            line.setEndX(pointPair.dest.x);
            line.setEndY(pointPair.dest.y);
            lineList.add(line);
        }
        return lineList;
    }

    /**
     * Breaks a string representing a location into an array of points.
     * The first element in the array is the x coordinate of the location
     * and the second element in the array is the y coordinate of the location.
     * @param point
     * @return
     */
    private Point2D parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");

        Point2D parsedPoint = new Point2D(Float.parseFloat(splitPoint[0]),
                                           Float.parseFloat(splitPoint[1]));                                          
        return parsedPoint;
    }

}
