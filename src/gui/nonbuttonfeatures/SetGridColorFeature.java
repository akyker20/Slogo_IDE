package gui.nonbuttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;


public class SetGridColorFeature extends ColorPicker {

    public SetGridColorFeature (GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setOnAction(event -> changeColor(targetDrawer));
        parentDrawer.drawShape(this);
        setPrefWidth(100);
        setPrefHeight(40);
    }

    private void changeColor (GridDrawer targetDrawer) {
        targetDrawer.changeGridColor("-fx-background-color: " + getPickerColor());
    }

    private String getPickerColor () {
        return "#" + SetGridColorFeature.this.getValue().toString().substring(2);
    }

}
