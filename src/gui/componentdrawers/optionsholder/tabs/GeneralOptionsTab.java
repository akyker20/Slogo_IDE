package gui.componentdrawers.optionsholder.tabs;

import javafx.scene.Node;

public class GeneralOptionsTab extends OptionsTab {
    private static final String TAB_NAME = "General";
    
    public GeneralOptionsTab(Node[] leftFeatures,Node[] rightFeatures){
        super(leftFeatures,rightFeatures, TAB_NAME);
    }
}
