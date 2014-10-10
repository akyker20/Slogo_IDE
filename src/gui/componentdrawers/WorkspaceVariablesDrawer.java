package gui.componentdrawers;

import gui.mainclasses.StageInitializer;

public class WorkspaceVariablesDrawer extends ComponentDrawer {

    public WorkspaceVariablesDrawer (String name) {
        super(name);
        getStyleClass().add("workspaceVariableDrawer");
        setPrefWidth(StageInitializer.SCREEN_WIDTH * ButtonHolderDrawer.OPTIONS_WIDTH_RATIO);
    }

}
