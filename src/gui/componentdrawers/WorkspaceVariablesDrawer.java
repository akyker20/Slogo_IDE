package gui.componentdrawers;

import gui.mainclasses.TextGenerator;
import javafx.scene.control.Label;


public class WorkspaceVariablesDrawer extends ComponentDrawer {

    public WorkspaceVariablesDrawer (String name) {
        super(name);
        getStyleClass().add("workspaceVariableDrawer");
        drawShape(new Label[] { new Label(TextGenerator.get(TextGenerator.WORKSPACE_VARIABLES)) });
    }

}
