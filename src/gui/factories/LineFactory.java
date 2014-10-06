package gui.factories;

import java.util.Map;
import Control.GUIState;
import Control.TurtleMovementInterpreter;
import javafx.scene.Node;
import javafx.scene.shape.Line;


public class LineFactory extends ObjectFactory {

    public LineFactory (String name) {
        super(name);
    }

    @Override

    public Node generateObject (Map<String, String> params) {

        Line line = new Line();
        float[] origin = parseStringToPoints(params.get(TurtleMovementInterpreter.ORIGIN2D));
        float[] destination = parseStringToPoints(params.get(TurtleMovementInterpreter.DESTINATION2D));
        
        line.setStartX(origin[0]);
        line.setStartY(origin[1]);
        line.setEndX(destination[0]);
        line.setEndY(destination[1]);
        return line;
    }
    
    private float[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");
        
        float[] parsedPoint = new float[]{(float) Double.parseDouble(splitPoint[0]),
                                            (float) Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }

}
