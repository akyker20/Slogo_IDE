package gui.componentdrawers;

import gui.mainclasses.TextGenerator;
import javafx.scene.control.Label;

/**
 * Class manages the workspace variables display
 * @author akyker20, allankiplagat
 *
 */
public class WorkspaceVariablesDrawer extends ComponentDrawer {

    public WorkspaceVariablesDrawer (String name) {
        super(name);
        getStyleClass().add("workspaceVariableDrawer");
        drawShape(new Label[] { new Label(TextGenerator.get(TextGenerator.WORKSPACE_VARIABLES)) });
    }

}
