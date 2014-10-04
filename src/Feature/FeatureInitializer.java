package Feature;

import GUI.ButtonHolderDrawer;
import GUI.CommandLineDrawer;
import GUI.ComponentDrawer;
import GUI.GridDrawer;

public class FeatureInitializer {

    public static void init(ComponentDrawer[] drawers){
        new SetBackgroundColorFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
        new CommandLineFeature((CommandLineDrawer) drawers[2]);
        new ToggleRelativeGridFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
    }
}
