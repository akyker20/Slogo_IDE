package gui.features;

import gui.componentdrawers.MenuDrawer;
import gui.mainclasses.GUIController;
import javafx.scene.control.Button;


public class HelpFeature extends Button {

    public HelpFeature (MenuDrawer parent) {
        setText(GUIController.GUI_TEXT.getString("help"));
        setOnAction(event -> openHelpDocument());
        parent.drawShape(this);
    }

    private void openHelpDocument () {
        System.out.println("Opened\n");
        // TODO
    }

}
