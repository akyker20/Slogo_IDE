package gui.nonbuttonfeatures.pen;

import gui.buttonfeatures.ButtonFeature;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;

/**
 * Abstract super class for Pen ChoiceBox features. Current sub-classes are
 * PenTypeFeature and PenUpOrDownFeature.
 * @author Austin Kyker
 *
 */
public abstract class PenChoiceBox extends ChoiceBox<String> {
    public PenChoiceBox(List<String> choices, OptionsHolderDrawer parentDrawer){
        this.setItems((ObservableList<String>) choices);
        this.setPrefSize(ButtonFeature.BUTTON_WIDTH, ButtonFeature.BUTTON_HEIGHT);
        this.setValue(choices.get(0));
        parentDrawer.drawShape(new Node[]{this});
    }
}