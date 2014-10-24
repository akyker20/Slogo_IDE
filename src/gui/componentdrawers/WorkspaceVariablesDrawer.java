package gui.componentdrawers;

import javafx.scene.control.Label;

public class WorkspaceVariablesDrawer extends ComponentDrawer {

    public WorkspaceVariablesDrawer (String name) {
        super(name);
        getStyleClass().add("workspaceVariableDrawer");
        this.drawShape(new Label[]{new Label("Workspace Variables")});
    }

}
