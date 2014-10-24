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

public class PenTypeFeature extends PenChoiceBox {
    
    private static final String SOLID = "solid";
    private static final String DASHED = "dashed";
    private static final String DOTTED = "dotted";
    private static final String PEN_TYPE = "pentype";

    public PenTypeFeature(ButtonHolderDrawer parentDrawer, SlogoGraphics control){
        super(FXCollections.observableArrayList(SOLID, DASHED, DOTTED), parentDrawer);
        
        this.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed (ObservableValue<? extends String> arg0, String oldValue, String selectedValue) {
                try {
                    control.parseCommandString(PEN_TYPE.concat(" " + selectedValue));
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