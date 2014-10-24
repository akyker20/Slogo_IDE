package gui.buttonfeatures;

import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import gui.mainclasses.GUIController;
import javafx.scene.control.Button;

public class ButtonFeature extends Button {
    public ButtonFeature(String text, ButtonHolderDrawer component) {
        setText(GUIController.GUI_TEXT.getString(text));
        setPrefWidth(100);
        setPrefHeight(40);
        component.drawShape(new ButtonFeature[]{this});
    }
}
