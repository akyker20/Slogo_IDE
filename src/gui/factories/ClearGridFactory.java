package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.GridDrawer;
import java.util.Map;
import javafx.scene.Node;

public class ClearGridFactory extends ObjectFactory {

    public ClearGridFactory (String name) {
        super(name);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        //place new grid 
        GridDrawer myDrawer = (GridDrawer) ComponentInitializer.DRAWER_MAP.get(ComponentInitializer.GRID_DRAWER);
        myDrawer.resetGrid();
        return new NullNode();
    }

}
