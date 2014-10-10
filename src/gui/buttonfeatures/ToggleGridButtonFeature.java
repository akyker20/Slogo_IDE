package gui.buttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import gui.mainclasses.GUIController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        super("toggleGrid", parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
