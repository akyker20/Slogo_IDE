package gui.nonbuttonfeatures.pen;

import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.workspace.Workspace;
import javafx.scene.control.Slider;


/**
 * This feature allows the user to change the thickness of the pen in pixels
 * interactively from the Pen tab in the options TabPane. The user simply slides
 * the slider to the thickness of the pixels desired and the back-end is notified
 * of the change so the pen workspace class can be updated.
 *
 * @author Austin Kyker
 *
 */
public class PenThicknessSliderFeature extends Slider {

    private static final String SET_PEN_SIZE = "setpensize";
    private static final int SLIDER_MIN = 1;
    private static final int SLIDER_MAX = 5;
    private static final int SLIDER_START = 5;
    private static final int SLIDER_TICK_UNIT = 1;

    private Workspace myWorkspace;

    public PenThicknessSliderFeature (OptionsHolderDrawer parentDrawer, Workspace workspace) {
        myWorkspace = workspace;
        setSliderProperties();
        setOnMouseReleased(event -> setPenSize());
        parentDrawer.drawShape(new PenThicknessSliderFeature[] { this });
    }

    private void setPenSize () {
        myWorkspace.parseCommandString(SET_PEN_SIZE + " " + getValue());
    }

    /**
     * Sets the properties of the slider.
     */
    private void setSliderProperties () {
        setMin(SLIDER_MIN);
        setMax(SLIDER_MAX);
        setValue(SLIDER_START);
        setShowTickLabels(true);
        setShowTickMarks(true);
        setMajorTickUnit(SLIDER_TICK_UNIT);
        setMinorTickCount(0);
        snapToTicksProperty().set(true);
        setWidth(ButtonFeature.BUTTON_WIDTH);
    }
}
