package gui.buttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.mainclasses.GUIController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class ToggleGridButtonFeature extends ButtonFeature {

    public ToggleGridButtonFeature (TurtleScreenDrawer targetDrawer, ButtonHolderDrawer parentDrawer) {
        super("toggleGrid", parentDrawer);
        setOnAction(event -> targetDrawer.toggleGrid());
    }
}
