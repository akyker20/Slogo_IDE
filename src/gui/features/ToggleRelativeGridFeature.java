package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import gui.mainclasses.GUIController;
import javafx.scene.control.Button;


public class ToggleRelativeGridFeature extends Button {

    public ToggleRelativeGridFeature (GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        setText(GUIController.GUI_TEXT.getString("toggleGrid"));
        setLayoutY(60);
        setOnAction(event -> targetDrawer.toggleGrid());
        parentDrawer.drawShape(this);
    }
}
