package gui.componentdrawers;

import javafx.scene.control.Label;
import gui.mainclasses.StageInitializer;


public class CommandLineDrawer extends ComponentDrawer {

    public CommandLineDrawer (String name) {
        super(name);
        getStyleClass().add("commandLine");
        setWidth(StageInitializer.SCREEN_WIDTH * GridDrawer.GRID_WIDTH_RATIO);
        this.drawShape(new Label("Command Line"));
    }

}
