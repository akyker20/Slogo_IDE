package gui.nonbuttonfeatures;

import gui.componentdrawers.SavedCommandsDrawer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import Control.SlogoGraphics;

public class SavedCommandsFeature extends ListView {
    public SavedCommandsFeature(SavedCommandsDrawer parentDrawer, SlogoGraphics control){
        ObservableList<String> items =FXCollections.observableArrayList (
                                                                         "fd 50", "fd 100", "+ 10 5", "* 5 3");
        this.setItems(items);
        this.setPrefHeight(168);
        this.setLayoutY(20);
        
        parentDrawer.drawShape(this);
    }
}
