package gui.nonbuttonfeatures;

import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import javafx.scene.control.ColorPicker;


/**
 * Abstract super class for color picker features. Current subclasses
 * are SetTurtleScreenColorFeature and PenColorPickerFeature.
 *
 * @author Austin Kyker
 *
 */
public abstract class ColorPickerFeature extends ColorPicker {
    public ColorPickerFeature (OptionsHolderDrawer parentDrawer) {
        parentDrawer.drawShape(new ColorPickerFeature[] { this });
        setPrefSize(ButtonFeature.BUTTON_WIDTH, ButtonFeature.BUTTON_HEIGHT);
    }
}
