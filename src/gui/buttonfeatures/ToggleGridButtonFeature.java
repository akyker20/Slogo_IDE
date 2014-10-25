package gui.buttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer, OptionsHolderDrawer parentDrawer) {
        super("toggleGrid", parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
