package gui.buttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.GuiTextGenerator;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer, OptionsHolderDrawer parentDrawer) {
        super(GuiTextGenerator.TOGGLE_GRID_TEXT, parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
