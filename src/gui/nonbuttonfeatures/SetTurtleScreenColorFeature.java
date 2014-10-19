package gui.nonbuttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;


public class SetTurtleScreenColorFeature extends ColorPicker {

    public SetTurtleScreenColorFeature (TurtleScreenDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setOnAction(event -> changeColor(targetDrawer));
        parentDrawer.drawShape(this);
        setPrefWidth(100);
        setPrefHeight(40);
    }

    private void changeColor (TurtleScreenDrawer targetDrawer) {
        targetDrawer.changeGridColor("-fx-background-color: " + getPickerColor());
    }

    private String getPickerColor () {
        return "#" + SetTurtleScreenColorFeature.this.getValue().toString().substring(2);
    }

}