package Feature;

import GUI.ButtonHolderDrawer;
import GUI.ComponentDrawer;
import GUI.GridDrawer;
import GUI.MenuDrawer;

public class FeatureInitializer {

    public static void init(ComponentDrawer[] drawers){
        new SetBackgroundColorFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
        new HelpFeature((MenuDrawer) drawers[2]);
    }
}
