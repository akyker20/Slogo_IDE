package gui.factories;

import gui.componentdrawers.ComponentInitializer;
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

        line.setStartX(origin[0]);
        line.setStartY(origin[1]);
        line.setEndX(destination[0]);
        line.setEndY(destination[1]);

        return line;
    }

    private double[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");

        double[] parsedPoint = new double[]{Double.parseDouble(splitPoint[0]),
                                            Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }

}
