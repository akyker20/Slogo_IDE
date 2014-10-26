package gui.buttonfeatures;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import gui.mainclasses.workspace.Workspace;


/**
 * This class offers the user the ability to clear the current workspace
 * variables and previous commands log. It will be a part of the general
 * options tab in the options TabPane.
 *
 * @author Austin Kyker
 *
 */

public class ClearWorkspaceButtonFeature extends ButtonFeature {

    public ClearWorkspaceButtonFeature (OptionsHolderDrawer parentDrawer, Workspace workspace) {
        super(TextGenerator.CLEAR_WORKSPACE, parentDrawer);
        setOnAction(event -> workspace.clear());
    }
}
