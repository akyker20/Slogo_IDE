package gui.factories;

import java.util.Map;
import javafx.scene.Node;

public class ClearGridFactory extends ObjectFactory {

    public ClearGridFactory (String name) {
        super(name);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        //place new grid 
        
        return new NullNode();
    }

}
