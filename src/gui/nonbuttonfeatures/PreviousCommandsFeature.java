package gui.nonbuttonfeatures;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.componentdrawers.PreviousCommandsDrawer;
import Control.SlogoGraphics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PreviousCommandsFeature extends ListView {

    private ObservableList<String> myPreviousCommandsList;

    public PreviousCommandsFeature(PreviousCommandsDrawer parentDrawer, SlogoGraphics control){
        myPreviousCommandsList = FXCollections.observableArrayList();
        this.setItems(myPreviousCommandsList);
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(100);
        this.setLayoutY(20);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    //double click
                    if(event.getClickCount() == 2){
                        try {
                            control.parseCommandString(PreviousCommandsFeature.this.getSelectionModel().getSelectedItem().toString());
                        }
                        catch (CompileTimeParsingException | RunTimeDivideByZeroException
                                | RunTimeNullPointerException | IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        parentDrawer.drawShape(this);
    }


    /**
     * @returns the observable list so it can be updated from the command line feature.
     */
    public ObservableList<String> getPreviousCommandsList () {
        return myPreviousCommandsList;
    }
}
