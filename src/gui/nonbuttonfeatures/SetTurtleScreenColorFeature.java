package gui.nonbuttonfeatures;

import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;

public class SetTurtleScreenColorFeature extends ColorPickerFeature {

    public SetTurtleScreenColorFeature (TurtleScreenDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        super(parentDrawer);
        setOnAction(event -> targetDrawer
                    .changeScreenColor("-fx-background-color: " + getPickerColor()));
    }
}
