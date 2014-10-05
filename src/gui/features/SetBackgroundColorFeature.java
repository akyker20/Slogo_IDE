package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import javafx.scene.control.ColorPicker;


public class SetBackgroundColorFeature extends ColorPicker {

    public SetBackgroundColorFeature (GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setOnAction(event -> changeColor(targetDrawer));
        parentDrawer.drawShape(this);
    }

    private void changeColor (GridDrawer targetDrawer) {
        targetDrawer.setStyle("-fx-background-color: " + getPickerColor());
    }

    private String getPickerColor () {
        return "#" + SetBackgroundColorFeature.this.getValue().toString().substring(2);
    }

}
