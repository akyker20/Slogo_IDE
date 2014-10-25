package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.workspace.Workspace;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

/**
 * Feature to allow the user to dynamically and interactively change the type
 * of the pen. The current options will be solid (default), dashed, and dotted.
 * A change listener is added to the choice box so that when the user selects
 * a different option, the control will be notified so the pen workspace class
 * on the back-end can be updated.
 * @author Austin Kyker
 *
 */
public class PenTypeFeature extends PenChoiceBox {

    private static final String SOLID = "solid";
    private static final String DASHED = "dashed";
    private static final String DOTTED = "dotted";
    private static final String PEN_TYPE = "pentype";

    public PenTypeFeature(OptionsHolderDrawer parentDrawer, Workspace workspace){
        super(FXCollections.observableArrayList(SOLID, DASHED, DOTTED), parentDrawer);

        this.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed (ObservableValue<? extends String> arg0, String oldValue, String selectedValue) {
                workspace.parseCommandString(PEN_TYPE.concat(" " + selectedValue));
            }      
        });
    }
}