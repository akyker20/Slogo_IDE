package gui.factories;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class TurtleNodes {
    
    public static final String TURTLE_IMAGE_ID = "turtleImageID";
  
    private Map<String, TurtleNode> myMap = new HashMap<String, TurtleNode>();

    public TurtleNode lookupNode (String imageID) {
        if(myMap.containsKey(imageID)){
            return myMap.get(imageID);
        }
        return null;
    }
    
    protected Node[] addTurtleNode(Map<String, String> params) throws FileNotFoundException {
        TurtleNode newTurtleNode = new TurtleNode(params);
        myMap.put(params.get(TURTLE_IMAGE_ID), newTurtleNode);
        return new ImageView[]{ newTurtleNode };
    }

    public void clearTurtleViews() {
        myMap.clear();
    }
}
