package gui.componentdrawers;

import javafx.scene.control.Label;
import gui.mainclasses.StageInitializer;


public class ButtonHolderDrawer extends ComponentDrawer {

    public ButtonHolderDrawer (String name) {
        super(name);
        this.drawShape(new Label("User Options"));
    }
}
