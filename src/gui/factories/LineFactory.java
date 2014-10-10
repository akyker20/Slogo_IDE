package gui.factories;

import gui.componentdrawers.GridDrawer;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.shape.Line;
import Control.TurtleMovementInterpreter;


public class LineFactory extends ObjectFactory {

    public LineFactory (String name) {
        super(name);
    }

    @Override

    public Node generateObject (Map<String, String> params) {

        Line line = new Line();
        float[] origin = parseStringToPoints(params.get(TurtleMovementInterpreter.ORIGIN2D));
        float[] destination = parseStringToPoints(params.get(TurtleMovementInterpreter.DESTINATION2D));
        
        line.setStartX(origin[0] + GridDrawer.GRID_WIDTH/2);
        line.setStartY(origin[1] + GridDrawer.GRID_HEIGHT/2);
        line.setEndX(destination[0] + GridDrawer.GRID_WIDTH/2);
        line.setEndY(destination[1] + GridDrawer.GRID_HEIGHT/2);
        return line;
    }
    
    private float[] parseStringToPoints(String point) {
        String[] splitPoint = point.split(" ");
        
        float[] parsedPoint = new float[]{(float) Double.parseDouble(splitPoint[0]),
                                            (float) Double.parseDouble(splitPoint[1])};
        return parsedPoint;
    }

}
