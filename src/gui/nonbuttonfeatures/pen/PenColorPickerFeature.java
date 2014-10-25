package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.nonbuttonfeatures.ColorPickerFeature;
import java.io.IOException;
import Control.SlogoGraphics;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

/**
 * Feature that allows user to interactively change the color of the pen
 * without using the command line. This feature will be located in the 
 * Pen tab in the options TabPane in the lower right hand corner of the 
 * IDE.
 * @author Austin Kyker
 *
 */
public class PenColorPickerFeature extends ColorPickerFeature {
    
    private static final String PEN_COLOR = "PC";
    
    private SlogoGraphics myControl;
    
    public PenColorPickerFeature (OptionsHolderDrawer parentDrawer, SlogoGraphics control) {
        super(parentDrawer);
        myControl = control;
        setOnAction(event -> changePenColor());
    }

    /**
     * Calls parse command on the control to let the back end know that the color
     * of the pen has been changed.
     */
    private void changePenColor () {
        try {
            myControl.parseCommandString(PEN_COLOR + " " + getPickerColor());
        }
        catch (CompileTimeParsingException | RunTimeDivideByZeroException
                | RunTimeNullPointerException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
