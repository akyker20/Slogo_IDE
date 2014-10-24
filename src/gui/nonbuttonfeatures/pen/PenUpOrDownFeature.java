package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import Control.SlogoGraphics;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;

/**
 * This class offers the user the ability to change whether the pen is
 * up or down from the pen options tab in the options TabPane. Therefore,
 * the user can change whether the pen is up or down from the CommandLine,
 * using this feature, or by loading a working script.
 * @author Austin Kyker
 *
 */
public class PenUpOrDownFeature extends PenChoiceBox {

    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String PEN = "pen";

    public PenUpOrDownFeature(ButtonHolderDrawer parentDrawer, SlogoGraphics control){
        super(FXCollections.observableArrayList(DOWN, UP), parentDrawer);
        
        this.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed (ObservableValue<? extends String> arg0, String oldValue, String selectedValue) {
                try {
                    control.parseCommandString(PEN.concat(selectedValue));
                }
                catch (CompileTimeParsingException | RunTimeDivideByZeroException
                        | RunTimeNullPointerException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }      
        });
    }
}