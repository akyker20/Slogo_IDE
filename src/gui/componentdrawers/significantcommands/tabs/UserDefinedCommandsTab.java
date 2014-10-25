package gui.componentdrawers.significantcommands.tabs;

import gui.nonbuttonfeatures.UserDefinedCommandsFeature;
import javafx.scene.control.Tab;

public class UserDefinedCommandsTab extends Tab {
    
    private static final String USER_DEFINED = "User Defined";
    private UserDefinedCommandsFeature myFeature;
    
    
    public UserDefinedCommandsTab (UserDefinedCommandsFeature feature) {
        this.setText(USER_DEFINED);
        this.setClosable(false);
        myFeature = feature;
        this.setContent(feature);
    }
}