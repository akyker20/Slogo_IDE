package gui.buttonfeatures;

import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import gui.mainclasses.GUIController;

/**
 * This class offers the user the ability to clear the current workspace
 * variables and previous commands log. It will be a part of the general
 * options tab in the options TabPane.
 * @author Austin Kyker
 *
 */
public class ClearWorkspaceButtonFeature extends ButtonFeature {
    public ClearWorkspaceButtonFeature (ButtonHolderDrawer parentDrawer, GUIController guiControl) {
        super("clearWorkspace", parentDrawer);
        setOnAction(event -> guiControl.clearCurrentWorkspace());
    }
}
