package gui.nonbuttonfeatures.pen;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import gui.mainclasses.workspace.Workspace;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;


/**
 * This class offers the user the ability to change whether the pen is
 * up or down from the pen options tab in the options TabPane. Therefore,
 * the user can change whether the pen is up or down from the CommandLine,
 * using this feature, or by loading a working script.
 *
 * @author Austin Kyker
 *
 */
public class PenUpOrDownFeature extends PenChoiceBox {
    private static final String PEN = "pen";
    private static TextGenerator textGen = TextGenerator.getInstance();

    public PenUpOrDownFeature (OptionsHolderDrawer parentDrawer, Workspace workspace) {
        super(FXCollections.observableArrayList(textGen.get(TextGenerator.DOWN),
                                                textGen.get(TextGenerator.UP)), parentDrawer);

        valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed (ObservableValue<? extends String> arg0,
                                 String oldValue,
                                 String selectedValue) {
                workspace.parseCommandString(PEN.concat(selectedValue));
            }
        });
    }
}
