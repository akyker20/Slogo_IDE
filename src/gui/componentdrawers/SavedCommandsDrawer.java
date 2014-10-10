package gui.componentdrawers;

import javafx.scene.control.Label;

public class SavedCommandsDrawer extends ComponentDrawer {

    public SavedCommandsDrawer (String name) {
        super(name);
        this.drawShape(new Label("Saved Commands"));
    }

}
