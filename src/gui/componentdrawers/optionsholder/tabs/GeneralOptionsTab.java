package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import javafx.scene.Node;

public class GeneralOptionsTab extends OptionsTab {
    
    public GeneralOptionsTab(Node[] leftFeatures,Node[] rightFeatures){
        super(leftFeatures,rightFeatures, TextGenerator.get(TextGenerator.GENERAL));
    }
}
