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
        ComponentInitializer.DRAWER_MAP.put( ComponentInitializer.GRID_DRAWER,  
                                             new GridDrawer( ComponentInitializer.GRID_DRAWER));
        return new NullNode();
    }

}
