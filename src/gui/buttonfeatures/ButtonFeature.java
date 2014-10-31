package gui.buttonfeatures;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import javafx.scene.control.Button;


/**
 * A button super class for buttons that will be added to the options holder component.
 *
 * @author Austin Kyker
 *
 */
public class ButtonFeature extends Button {

    public static final int BUTTON_WIDTH = 120;
    public static final int BUTTON_HEIGHT = 40;
    private TextGenerator textGen = TextGenerator.getInstance();

    public ButtonFeature (String text, OptionsHolderDrawer component) {
        setText(textGen.get(text));
        setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        component.drawShape(new ButtonFeature[] { this });
    }
}
