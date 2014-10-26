package gui.nonbuttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;

/**
 * Class is a ColorPickerFeature that allows the user to set the color of the TurtleScreen
 * @author akyker20
 *
 */
public class SetTurtleScreenColorFeature extends ColorPickerFeature {

    public SetTurtleScreenColorFeature (TurtleScreenDrawer targetDrawer,
                                        OptionsHolderDrawer parentDrawer) {
        super(parentDrawer);
        setOnAction(event -> targetDrawer
                    .changeScreenColor(this.getValue()));
    }
}
