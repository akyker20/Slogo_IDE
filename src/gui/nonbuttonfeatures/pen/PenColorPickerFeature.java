package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.workspace.Workspace;
import gui.nonbuttonfeatures.ColorPickerFeature;


/**
 * Feature that allows user to interactively change the color of the pen
 * without using the command line. This feature will be located in the
 * Pen tab in the options TabPane in the lower right hand corner of the
 * IDE.
 *
 * @author Austin Kyker
 *
 */
public class PenColorPickerFeature extends ColorPickerFeature {

    private static final String SET_PEN_COLOR = "setpencolor 0";
    private static final String SET_PALETTE = "setpalette";

    private Workspace myWorkspace;

    public PenColorPickerFeature (OptionsHolderDrawer parentDrawer, Workspace workspace) {
        super(parentDrawer);
        myWorkspace = workspace;
        setOnAction(event -> changePenColor());
    }

    /**
     * Calls parse command on the control to let the back end know that the color
     * of the pen has been changed.
     */
    private void changePenColor () {
        myWorkspace.parseCommandString(SET_PALETTE + " 0 " + getRGBStr());
        myWorkspace.parseCommandString(SET_PEN_COLOR);
    }

    private String getRGBStr () {
        return getValue().getRed() + " " +
                getValue().getBlue() + " " +
                getValue().getRed();
    }
}
