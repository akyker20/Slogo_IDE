package gui.factories.turtlefactory;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.ObjectFactory;
import gui.mainclasses.FactoryBuilder;
import java.util.Map;
import javafx.scene.Node;

/**
 * Class handles turtle creation on front-end. It makes use
 * of the turtlenodes and turtlenode class to manage the turtle
 * nodes that are displayed in the turtle screen component.
 * @author akyker20, allankiplagat
 *
 */
public class TurtleFactory extends ObjectFactory {

    public static final String PARENT = ComponentBuilder.SCREEN_DRAWER;
    public static final String TYPE = FactoryBuilder.TURTLE_FACTORY;
    public static final String HEADING = "heading";
    public static final String LOCATION = "location";
    public static final String OPACITY = "opacity";
    public static final String TURTLE_ID = "turtleID";
    public static final String IMAGE_PATH = "imagePath";
    public static final String DELETION_FLAG = "deletionFlag";

    private TurtleNodes myTurtleNodes;

    public TurtleFactory (String name, TurtleNodes turtleNodes) {
        super(name);
        myTurtleNodes = turtleNodes;
    }

    /**
     * Looks to see if the drawable object id parameter matches that
     * of a turtle that already exists. If this is the case, then that
     * turtle is updated. Otherwise, a new turtle node is added.
     */
    @Override
    public Node[] generateObject (Map<String, String> params) {
        TurtleNode turtleNode = myTurtleNodes.getTurtleWithID(params.get(TURTLE_ID));
        if (turtleNode == null) {
                return myTurtleNodes.addTurtleNode(params);
        }
        return turtleNode.updatePosition(params);
    }
}
