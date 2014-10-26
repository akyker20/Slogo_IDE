package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import javafx.scene.Node;

public class PenOptionsTab extends OptionsTab {
    
    public PenOptionsTab(Node[] leftFeatures,Node[] rightFeatures){
        super(leftFeatures,rightFeatures,TextGenerator.get(TextGenerator.PEN));
    }
}
