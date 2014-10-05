package gui.componentdrawers;

import gui.mainclasses.StageInitializer;


public class CommandLineDrawer extends ComponentDrawer {

    public CommandLineDrawer (String name) {
        super(name);
        getStyleClass().add("commandLine");
        setPrefWidth(StageInitializer.SCREEN_WIDTH * GridDrawer.GRID_WIDTH_RATIO);
    }

}
