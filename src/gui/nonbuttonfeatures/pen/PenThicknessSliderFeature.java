package gui.nonbuttonfeatures.pen;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import Control.SlogoGraphics;
import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.workspace.Workspace;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;

/**
 * This feature allows the user to change the thickness of the pen in pixels
 * interactively from the Pen tab in the options TabPane. The user simply slides
 * the slider to the thickness of the pixels desired and the back-end is notified
 * of the change so the pen workspace class can be updated.
 * @author Austin Kyker
 *
 */
public class PenThicknessSliderFeature extends Slider {
    
    private static final String SET_PEN_SIZE = "setpensize";

    private Workspace myWorkspace;

    public PenThicknessSliderFeature(OptionsHolderDrawer parentDrawer, Workspace workspace){
        myWorkspace = workspace;
        setSliderProperties();
        this.setOnMouseReleased(event->setPenSize());
        parentDrawer.drawShape(new PenThicknessSliderFeature[]{this});
    }
        

    private void setPenSize () {
        myWorkspace.parseCommandString(SET_PEN_SIZE + " " + this.getValue());
    }

    /**
     * Sets the properties of the slider.
     */
    private void setSliderProperties () {
        setMin(1);
        setMax(5);
        setValue(1);
        setShowTickLabels(true);
        setShowTickMarks(true);
        setMajorTickUnit(1);
        setMinorTickCount(0);
        snapToTicksProperty().set(true);
        setWidth(ButtonFeature.BUTTON_WIDTH);       
    }
}
