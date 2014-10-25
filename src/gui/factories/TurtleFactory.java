package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.factories.nodes.TurtleNode;
import gui.factories.nodes.TurtleNodes;

import java.io.FileNotFoundException;
import java.util.Map;

import javafx.scene.Node;


public class TurtleFactory extends ObjectFactory {

    public static final String PARENT = ComponentInitializer.GRID_DRAWER;
    public static final String TYPE = FactoryInitializer.TURTLE_FACTORY;
    public static final String HEADING = "heading";
    public static final String LOCATION = "location";
    public static final String OPACITY = "opacity";
    public static final String TURTLE_IMAGE_ID = "turtleImageID";
	public static final String IMAGE_PATH = "imagePath";


    private TurtleNodes myTurtleNodes;

    public TurtleFactory (String name, TurtleNodes turtleNodes) {
        super(name);
        myTurtleNodes = turtleNodes;
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        TurtleNode turtleNode = myTurtleNodes.lookupNode(params.get(TURTLE_IMAGE_ID));
        if(turtleNode == null){

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
