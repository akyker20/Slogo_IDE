package gui.nonbuttonfeatures;

import gui.componentdrawers.PreviousCommandsDrawer;
import Control.SlogoGraphics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PreviousCommandsFeature extends ListView {
    public PreviousCommandsFeature(PreviousCommandsDrawer parentDrawer, SlogoGraphics control){
        ObservableList<String> items =FXCollections.observableArrayList (
                                                                         "Single", "Double", "Suite", "Family App");
        this.setItems(items);
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(100);
        this.setLayoutY(20);
        
        parentDrawer.drawShape(this);
    }
}
