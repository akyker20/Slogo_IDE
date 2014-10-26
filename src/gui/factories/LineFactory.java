package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.mainclasses.FactoryBuilder;
import gui.turtlescreenwrap.CoordinateChanger;
import gui.turtlescreenwrap.Point2DPair;
import gui.turtlescreenwrap.TurtleScreenWrap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import com.sun.javafx.geom.Point2D;

/**
 * Class generates lines to be drawn on the TurtleScreen
 * @author akyker20, allankiplagat
 *
 */
public class LineFactory extends ObjectFactory {

    public static final String ORIGIN = "origin";
    public static final String DESTINATION = "destination";
    public static final String PARENT = ComponentBuilder.SCREEN_DRAWER;
    public static final String TYPE = FactoryBuilder.LINE_FACTORY;
    public static final String LINE_WIDTH = "lineWidth";
    public static final String LINE_COLOR = "lineColor";

    public LineFactory (String name) {
        super(name);
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        List<Line> linesList = generateLines(params);
        Line[] lines = new Line[linesList.size()];
        for (int k = 0; k < linesList.size(); k++) {
            lines[k] = linesList.get(k);
        }
        return lines;
    }

    /**
     * Method generates lines to be drawn on the TurtleScreen
     * @param params
     * @return returns a list of Lines to be drawn 
     */
    public List<Line> generateLines (Map<String, String> params) {

        Point2D origin = parseStringToPoints(params.get(ORIGIN));
        Point2D dest = parseStringToPoints(params.get(DESTINATION));

        // split into 'sub-lines'
        List<Point2DPair> pointPairs = TurtleScreenWrap.
                fragmentPoint2DPair(new Point2DPair(origin, dest));

        List<Line> lineList = new ArrayList<Line>();
        for (Point2DPair pointPair : pointPairs) {
            Line line = new Line();
            line.setStartX(CoordinateChanger.convX(pointPair.origin.x));
            line.setStartY(CoordinateChanger.convY(pointPair.origin.y));
            line.setEndX(CoordinateChanger.convX(pointPair.dest.x));
            line.setEndY(CoordinateChanger.convY(pointPair.dest.y));
            lineList.add(line);
            line.setStrokeWidth(Double.parseDouble(params.get(LINE_WIDTH)));
            line.setStroke(Color.valueOf(params.get(LINE_COLOR)));
        }

        return lineList;
    }

    /**
     * Breaks a string representing a location into an array of points.
     * The first element in the array is the x coordinate of the location
     * and the second element in the array is the y coordinate of the location.
     *
     * @param point
     * @return
     */
    private Point2D parseStringToPoints (String point) {
        String[] splitPoint = point.split(" ");

        Point2D parsedPoint = new Point2D(Float.parseFloat(splitPoint[0]),
                                          Float.parseFloat(splitPoint[1]));
        return parsedPoint;
    }

}
