package gui.nonbuttonfeatures.pen;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import Control.SlogoGraphics;
import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
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
    
    private static final String SET_PEN_SIZE = "SETPS";

    private SlogoGraphics myControl;

    public PenThicknessSliderFeature(ButtonHolderDrawer parentDrawer, SlogoGraphics control){
        myControl = control;
        setSliderProperties();
        setChangeListener();
        parentDrawer.drawShape(new PenThicknessSliderFeature[]{this});
    }

    /**
     * Sets the change listener on the slider. If the user selects a 
     * different pixel size for the pen, the control updates the backend
     * with the change.
     */
    private void setChangeListener () {
        this.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number oldVal, Number newVal) {
                try {
                    myControl.parseCommandString(SET_PEN_SIZE + " " + newVal);
                }
                catch (CompileTimeParsingException | RunTimeDivideByZeroException
                        | RunTimeNullPointerException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
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
