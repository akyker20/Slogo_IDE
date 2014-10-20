package gui.nonbuttonfeatures;

import java.io.IOException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import Control.SlogoGraphics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class is a list view used to store previous commands. All commands that are entered
 * are put into this list (including commands that raise exceptions - thats how its done
 * in Matlab and other IDEs). The user can run a previous command by double clicking on
 * a list item.
 * @author Austin Kyker
 *
 */
public class PreviousCommandsFeature extends ListView {

    private ObservableList<String> myPreviousCommandsList;

    public PreviousCommandsFeature(PreviousCommandsDrawer parentDrawer, 
                                   CommandLineDrawer commandLineDrawer){
        myPreviousCommandsList = FXCollections.observableArrayList();
        this.setItems(myPreviousCommandsList);
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(100);
        this.setLayoutY(20);
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * If the user double clicks on a previous command, that command is run.
             */
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        String selectedCommand = PreviousCommandsFeature.this
                                .getSelectionModel().getSelectedItem().toString();
                        commandLineDrawer.setCommandLine(selectedCommand);
                    }
                }
            }
        });
        parentDrawer.drawShape(new PreviousCommandsFeature[]{this});
    }


    /**
     * @returns the observable list so it can be updated from the command line feature.
     */
    public ObservableList<String> getPreviousCommandsList () {
        return myPreviousCommandsList;
    }
}
