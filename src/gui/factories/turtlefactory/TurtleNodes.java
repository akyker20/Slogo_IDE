package gui.factories.turtlefactory;

import gui.mainclasses.workspace.Workspace;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class TurtleNodes {
  
    private List<TurtleNode> myTurtleNodes = new ArrayList<TurtleNode>();
    private Workspace myWorkspace;
    
    public TurtleNodes(Workspace workspace){
        myWorkspace = workspace;
    }

    public TurtleNode getTurtleWithID(String imageID) {
        for(TurtleNode node:myTurtleNodes){
            if(node.getTurtleID().equals(imageID)) {
                return node;
            }
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
        TurtleNode newTurtleNode = new TurtleNode(params, myWorkspace);
        myTurtleNodes.add(newTurtleNode);
        return new ImageView[]{ newTurtleNode };
    }

    /**
     * Removes all the turtle nodes from the list. This method is called when a clear screen
     * drawable object arrives.
     */
    public void clearTurtleNodes() {
        myTurtleNodes.clear();
    }

    /**
     * Returns the active nodes. This is used in the stage initializer class to set up the 
     * key listener that will allow the user to move the active turtles.
     * @return List of active turtle nodes.
     */
    public List<TurtleNode> getActiveNodes () {
       return myTurtleNodes.stream()
               .filter(TurtleNode::isSelected)
               .collect(Collectors.toList());
    }
}
