package gui.nonbuttonfeatures;

import gui.componentdrawers.ErrorDrawer;
import javafx.scene.control.ListView;

/**
 * Errors are displayed by this class.
 * @author akyker20
 *
 */
public class ErrorDisplayFeature extends ListView<String> {
    
    private static final int HEIGHT = 30;
    private static final int MARGIN_TOP = 20;
    
    public ErrorDisplayFeature (ErrorDrawer parentDrawer) {
        setPrefWidth(parentDrawer.getWidth());
        setPrefHeight(HEIGHT);
        setLayoutY(MARGIN_TOP);
        parentDrawer.setParentNode(this);
    }

}
