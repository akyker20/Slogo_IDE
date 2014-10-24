package gui.buttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        super("toggleGrid", parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
