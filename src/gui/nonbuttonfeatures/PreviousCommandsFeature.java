package gui.nonbuttonfeatures;

import gui.componentdrawers.PreviousCommandsDrawer;
import Control.SlogoGraphics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PreviousCommandsFeature extends ListView {
    
    private ObservableList<String> myPreviousCommandsList;
    
    public PreviousCommandsFeature(PreviousCommandsDrawer parentDrawer, SlogoGraphics control){
        myPreviousCommandsList = FXCollections.observableArrayList();
        this.setItems(myPreviousCommandsList);
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(100);
        this.setLayoutY(20);
        
        parentDrawer.drawShape(this);
    }

    
    /**
     * @returns the observable list so it can be updated from the command line feature.
     */
    public ObservableList<String> getPreviousCommandsList () {
        return myPreviousCommandsList;
    }
}
