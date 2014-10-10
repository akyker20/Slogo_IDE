package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import javafx.scene.control.ColorPicker;


public class SetGridColorFeature extends ColorPicker {

    public SetGridColorFeature (GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setOnAction(event -> changeColor(targetDrawer));
        parentDrawer.drawShape(this);
        this.setLayoutY(20);
    }

    private void changeColor (GridDrawer targetDrawer) {
        targetDrawer.changeGridColor("-fx-background-color: " + getPickerColor());
    }

    private String getPickerColor () {
        return "#" + SetGridColorFeature.this.getValue().toString().substring(2);
    }

}
