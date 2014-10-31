// This entire file is part of my masterpiece.
// Austin Kyker

package gui.factories.turtlefactory;

import gui.mainclasses.workspace.Workspace;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Class represents a collection of TurtleNode objects.
 * @author akyker20
 *
 */
public class TurtleNodes {

    private List<TurtleNode> myTurtleNodes = new ArrayList<TurtleNode>();
    private Workspace myWorkspace;

    public TurtleNodes (Workspace workspace) {
        myWorkspace = workspace;
    }

    /**
     * Looks for a turtle with an id of imageID. If it finds the turtle,
     * it returns it. Otherwise, it returns null.
     * @param imageID
     * @return
     */
    public TurtleNode getTurtleWithID (String imageID) {
        for (TurtleNode node : myTurtleNodes) {
            if (node.getTurtleID().equals(imageID)) { return node; }
        }
        return null;
    }

    /**
     * Adds a new turtle node. This is called when a new turtle is created.
     *
     * @param params
     * @return
     */
    public Node[] addTurtleNode (Map<String, String> params) {
        TurtleNode newTurtleNode = new TurtleNode(params, myWorkspace);
        myTurtleNodes.add(newTurtleNode);
        return new ImageView[] { newTurtleNode };
    }

    /**
     * Removes all the turtle nodes from the list. This method is called when a clear screen
     * DrawableObject arrives.
     */
    public void clearTurtleNodes () {
        myTurtleNodes.clear();
    }

    /**
     * Returns the active nodes. This is used to when a turtle is selected or deselected
     * to tell the backend which turtles are now active.
     *
     * @return List of active turtle nodes.
     */
    public List<TurtleNode> getActiveNodes () {
        return myTurtleNodes.stream()
                .filter(TurtleNode::isSelected)
                .collect(Collectors.toList());
    }
}
