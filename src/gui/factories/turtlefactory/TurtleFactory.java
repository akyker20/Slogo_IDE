package gui.factories.turtlefactory;

import gui.componentdrawers.ComponentBuilder;
import gui.factories.ObjectFactory;
import gui.mainclasses.FactoryBuilder;
import java.io.FileNotFoundException;
import java.util.Map;
import javafx.scene.Node;

/**
 * Class handles turtle creation on front-end
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

    @Override
    public Node[] generateObject (Map<String, String> params) {
        TurtleNode turtleNode = myTurtleNodes.getTurtleWithID(params.get(TURTLE_ID));
        if (turtleNode == null) {
            try {
                return myTurtleNodes.addTurtleNode(params);
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return turtleNode.updatePosition(params);
    }
}
