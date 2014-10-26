package gui.componentdrawers.optionsholder.tabs;

import gui.mainclasses.TextGenerator;
import javafx.scene.Node;


/**
 * This class will hold general options features such as toggle relative grid,
 * set turtle screen background color, and image dropper.
 *
 * @author akyker20
 *
 */
public class GeneralOptionsTab extends OptionsTab {

    public GeneralOptionsTab (Node[] leftFeatures, Node[] rightFeatures) {
        super(leftFeatures, rightFeatures, TextGenerator.get(TextGenerator.GENERAL));
    }
}
