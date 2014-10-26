package gui.nonbuttonfeatures;

import gui.componentdrawers.ErrorDrawer;
import javafx.scene.control.ListView;

/**
 * Errors are displayed by this class.
 * @author akyker20
 *
 */
public class ErrorDisplayFeature extends ListView<String> {
    public ErrorDisplayFeature (ErrorDrawer parentDrawer) {
        setPrefWidth(parentDrawer.getWidth());
        setPrefHeight(30);
        setLayoutY(20);
        parentDrawer.setParentNode(this);
    }

}
