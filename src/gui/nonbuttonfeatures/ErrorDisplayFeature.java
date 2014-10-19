package gui.nonbuttonfeatures;

import gui.componentdrawers.ErrorDrawer;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ErrorDisplayFeature extends ListView {
    public ErrorDisplayFeature(ErrorDrawer parentDrawer){
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(30);
        this.setLayoutY(20);
        parentDrawer.setParentNode(this);
    }

}
