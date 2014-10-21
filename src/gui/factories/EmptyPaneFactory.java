package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.nodes.NullNode;
import java.util.Map;
import javafx.scene.Node;

public class EmptyPaneFactory extends ObjectFactory {

    public static final String PARENT = ComponentInitializer.GRID_DRAWER;
    public static final String TYPE = FactoryInitializer.CLEAR_GRID_FACTORY;
    
    private TurtleScreenDrawer myTurtleScreen;

    public EmptyPaneFactory (String name, TurtleScreenDrawer drawer) {
        super(name);
        myTurtleScreen = drawer;
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        //place new grid 
        myTurtleScreen.resetScreen();
//        error here
        return new Node[]{new NullNode()};
    }

}
