package gui.buttonfeatures;

import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.GUIController;
import gui.mainclasses.GuiTextGenerator;
import javafx.scene.control.Button;

public class ButtonFeature extends Button {
    
    public static final int BUTTON_WIDTH = 120;
    public static final int BUTTON_HEIGHT = 40;
    
    public ButtonFeature(String text, OptionsHolderDrawer component) {
        setText(GuiTextGenerator.get(text));
        setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        component.drawShape(new ButtonFeature[]{this});
    }
}
