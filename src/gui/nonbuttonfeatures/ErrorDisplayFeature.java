package gui.nonbuttonfeatures;

import gui.componentdrawers.ErrorDrawer;
import javafx.scene.control.ListView;

public class ErrorDisplayFeature extends ListView<String> {
    public ErrorDisplayFeature(ErrorDrawer parentDrawer){
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(30);
        this.setLayoutY(20);
        parentDrawer.setParentNode(this);
    }

}
