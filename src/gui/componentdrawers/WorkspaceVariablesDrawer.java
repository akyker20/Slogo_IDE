package gui.componentdrawers;

import javafx.scene.control.Label;
import gui.mainclasses.StageInitializer;

public class WorkspaceVariablesDrawer extends ComponentDrawer {

    public WorkspaceVariablesDrawer (String name) {
        super(name);
        getStyleClass().add("workspaceVariableDrawer");
        this.drawShape(new Label("Workspace Variables"));
    }

}
