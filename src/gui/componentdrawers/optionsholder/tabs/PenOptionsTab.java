package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import javafx.scene.Node;

/**
 * This tab will have all of the pen options such as options to change the
 * width of the pen, the color of the pen, and whether the pen is up or down.
 * @author akyker20
 *
 */
public class PenOptionsTab extends OptionsTab {
    
    public PenOptionsTab(Node[] leftFeatures,Node[] rightFeatures){
        super(leftFeatures,rightFeatures,TextGenerator.get(TextGenerator.PEN));
    }
}
