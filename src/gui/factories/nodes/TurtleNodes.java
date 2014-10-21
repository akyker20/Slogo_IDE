package gui.factories.nodes;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class TurtleNodes {
    
    public static final String TURTLE_IMAGE_ID = "turtleImageID";
  
    private Map<String, TurtleNode> myMap = new HashMap<String, TurtleNode>();

    /**
     * Looks up the turtle node based on its image id. This is used in the turtle
     * factory generateShape method when it is trying to determine if a new turtle
     * has been created or an old turtle is being updated.
     * @param imageID
     * @return
     */
    public TurtleNode lookupNode (String imageID) {
        if(myMap.containsKey(imageID)){
            return myMap.get(imageID);
        }
        return null;
    }
    
    /**
     * Adds a new turtle node. This is called when a new turtle is created.
     * @param params
     * @return
     * @throws FileNotFoundException
     */
    public Node[] addTurtleNode(Map<String, String> params) throws FileNotFoundException {
        TurtleNode newTurtleNode = new TurtleNode(params);
        myMap.put(params.get(TURTLE_IMAGE_ID), newTurtleNode);
        return new ImageView[]{ newTurtleNode };
    }

    /**
     * Removes all the turtle nodes from the list. This method is called when a clear screen
     * drawable object arrives.
     */
    public void clearTurtleNodes() {
        myMap.clear();
    }

    /**
     * Returns the active nodes. This is used in the stage initializer class to set up the 
     * key listener that will allow the user to move the active turtles.
     * @return List of active turtle nodes.
     */
    public List<TurtleNode> getActiveNodes () {
       return myMap.values().stream()
               .filter(TurtleNode::isSelected)
               .collect(Collectors.toList());
    }
}
