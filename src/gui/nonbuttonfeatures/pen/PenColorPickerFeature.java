package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import gui.nonbuttonfeatures.ColorPickerFeature;
import java.io.IOException;
import Control.SlogoGraphics;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

public class PenColorPickerFeature extends ColorPickerFeature {
    
    private static final String PEN_COLOR = "PC";
    
    private SlogoGraphics myControl;
    
    public PenColorPickerFeature (ButtonHolderDrawer parentDrawer, SlogoGraphics control) {
        super(parentDrawer);
        myControl = control;
        setOnAction(event -> changePenColor());
    }

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
