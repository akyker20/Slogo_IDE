package gui.componentdrawers;

import javafx.scene.control.Label;
import gui.mainclasses.StageInitializer;

public class PreviousCommandsDrawer extends ComponentDrawer {

    public PreviousCommandsDrawer (String name) {
        super(name);
        this.getStyleClass().add("previousCommands");
        this.setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        this.drawShape(new Label[]{new Label("Previous Commands")});
    }

}
