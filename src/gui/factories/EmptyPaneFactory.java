package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;

import java.util.Map;

import javafx.scene.Node;

public class EmptyPaneFactory extends ObjectFactory {
	
	public static final String PARENT = ComponentInitializer.GRID_DRAWER;
	public static final String TYPE = FactoryInitializer.CLEAR_GRID_FACTORY;

    public EmptyPaneFactory (String name) {
        super(name);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        //place new grid 
        TurtleScreenDrawer myDrawer = (TurtleScreenDrawer) ComponentInitializer.DRAWER_MAP.get(ComponentInitializer.GRID_DRAWER);
        myDrawer.resetGrid();
        TurtleFactory.clearTurtleViews();
        return new NullNode();
    }

}
