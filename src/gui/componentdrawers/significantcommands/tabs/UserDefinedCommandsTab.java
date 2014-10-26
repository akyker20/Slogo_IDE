package gui.componentdrawers.significantcommands.tabs;

import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.tableviews.UserDefinedCommandsFeature;
import javafx.scene.control.Tab;

public class UserDefinedCommandsTab extends Tab {
    
    private UserDefinedCommandsFeature myFeature;
    
    public UserDefinedCommandsTab (UserDefinedCommandsFeature feature) {
        this.setText(TextGenerator.get(TextGenerator.USER_DEFINED));
        this.setClosable(false);
        myFeature = feature;
        this.setContent(feature);
    }
}