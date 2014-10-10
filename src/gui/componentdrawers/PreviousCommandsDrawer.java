package gui.componentdrawers;

import javafx.scene.control.Label;
import gui.mainclasses.StageInitializer;

public class PreviousCommandsDrawer extends ComponentDrawer {

    public PreviousCommandsDrawer (String name) {
        super(name);
        this.getStyleClass().add("previousCommands");
        this.setWidth(StageInitializer.SCREEN_WIDTH * GridDrawer.GRID_WIDTH_RATIO);
        this.drawShape(new Label("Previous Commands"));
    }

}
