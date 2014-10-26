package gui.componentdrawers.significantcommands.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.UserDefinedCommandsFeature;
import javafx.scene.control.Tab;


/**
 * A tab to show the user defined commands.
 *
 * @author akyker20
 *
 */
public class UserDefinedCommandsTab extends Tab {

    private UserDefinedCommandsFeature myFeature;

    public UserDefinedCommandsTab (UserDefinedCommandsFeature feature) {
        setText(TextGenerator.get(TextGenerator.USER_DEFINED));
        setClosable(false);
        myFeature = feature;
        setContent(feature);
    }
}
