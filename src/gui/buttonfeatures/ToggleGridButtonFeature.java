package gui.buttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer, OptionsHolderDrawer parentDrawer) {
        super(TextGenerator.TOGGLE_GRID, parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
