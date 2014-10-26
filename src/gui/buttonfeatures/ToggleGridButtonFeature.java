package gui.buttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;


/**
 * The purpose of this class is to allow the user to toggle a relative grid on or
 * off in the Turtle Screen Drawer.
 *
 * @author akyker20
 *
 */
public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer,
                                    OptionsHolderDrawer parentDrawer) {
        super(TextGenerator.TOGGLE_GRID, parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
