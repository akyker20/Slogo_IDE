package gui.factories;

import java.util.Map;
import javafx.scene.Node;
import javafx.scene.shape.Line;


public class LineFactory extends ObjectFactory {

    public LineFactory (String name) {
        super(name);
    }

    @Override
    public Node drawObject (Map<String, String> params) {
        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(100.0f);
        line.setEndY(100.0f);
        return line;
    }

}
