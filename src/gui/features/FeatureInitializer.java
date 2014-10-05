package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.GridDrawer;
import gui.componentdrawers.MenuDrawer;
import Control.SlogoGraphics;


public class FeatureInitializer {

    public static void init (ComponentDrawer[] drawers, SlogoGraphics control) {
        new SetBackgroundColorFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
        new HelpFeature((MenuDrawer) drawers[3]);
        new CommandLineFeature((CommandLineDrawer) drawers[2], control);
        new ToggleRelativeGridFeature((GridDrawer) drawers[0], (ButtonHolderDrawer) drawers[1]);
    }
}
