package gui.nonbuttonfeatures;

import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import javafx.scene.control.ColorPicker;


public class SetTurtleScreenColorFeature extends ColorPicker {

    public SetTurtleScreenColorFeature (TurtleScreenDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setOnAction(event -> changeColor(targetDrawer));
        parentDrawer.drawShape(new SetTurtleScreenColorFeature[]{this});
        setPrefSize(ButtonFeature.BUTTON_WIDTH, ButtonFeature.BUTTON_HEIGHT);
    }

    private void changeColor (TurtleScreenDrawer targetDrawer) {
        targetDrawer.changeGridColor("-fx-background-color: " + getPickerColor());
    }

    private String getPickerColor () {
        return "#" + SetTurtleScreenColorFeature.this.getValue().toString().substring(2);
    }

}
