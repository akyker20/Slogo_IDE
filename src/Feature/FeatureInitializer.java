package Feature;

import Control.SlogoGraphics;
import GUI.ButtonHolderDrawer;
import GUI.CommandLineDrawer;
import GUI.ComponentDrawer;
import GUI.GridDrawer;
import GUI.MenuDrawer;

public class FeatureInitializer {

    public static void init(ComponentDrawer[] drawers, SlogoGraphics control){
        new SetBackgroundColorFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
        new HelpFeature((MenuDrawer) drawers[3]);
        new CommandLineFeature((CommandLineDrawer) drawers[2], control);
        new ToggleRelativeGridFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
    }
}
