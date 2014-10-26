package gui.nonbuttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;


public class SetTurtleScreenColorFeature extends ColorPickerFeature {

    public SetTurtleScreenColorFeature (TurtleScreenDrawer targetDrawer,
                                        OptionsHolderDrawer parentDrawer) {
        super(parentDrawer);
        setOnAction(event -> targetDrawer
                    .changeScreenColor(this.getValue()));
    }
}
