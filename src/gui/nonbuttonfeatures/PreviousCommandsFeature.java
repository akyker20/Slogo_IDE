package gui.nonbuttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import javafx.collections.ObservableList;
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
public class PreviousCommandsFeature extends ListView<String> {

    private ObservableList<String> myPreviousCommandsList;
    private CommandLineDrawer myCommandLineDrawer;

    public PreviousCommandsFeature(PreviousCommandsDrawer parentDrawer, 
                                   CommandLineDrawer commandLineDrawer,
                                   ObservableList<String> previousCommands){
        myPreviousCommandsList = previousCommands;
        myCommandLineDrawer = commandLineDrawer;
        this.setItems(myPreviousCommandsList);
        this.setPrefWidth(parentDrawer.getWidth());
        this.setPrefHeight(100);
        this.setLayoutY(20);    
        this.setOnMouseClicked(event->displayPreviousCommandInCommandLineOnDblClick(event));
        parentDrawer.drawShape(new PreviousCommandsFeature[]{this});
    }

    /**
     * When the user double clicks on a previous command that command will be displayed in the command
     * line so the user can quickly run it by hitting enter.
     * @param event
     */
    private void displayPreviousCommandInCommandLineOnDblClick (MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            if(event.getClickCount() == 2){
                String selectedCommand = PreviousCommandsFeature.this
                        .getSelectionModel().getSelectedItem().toString();
                myCommandLineDrawer.setCommandLine(selectedCommand);
            }
        }
    }


    /**
     * @returns the observable list so it can be updated from the command line feature.
     */
    public ObservableList<String> getPreviousCommandsList () {
        return myPreviousCommandsList;
    }
}
