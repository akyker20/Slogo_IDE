package gui.nonbuttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SavedCommandsFeature extends ListView<String> {
    
    private ObservableList<String> myCommands;
    
    public SavedCommandsFeature(CommandLineDrawer commandLineDrawer){
        myCommands = FXCollections.observableArrayList();
        this.setItems(myCommands);
        this.setPrefHeight(168);
        this.setLayoutY(20);
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * If the user double clicks on a previous command, that command is run.
             */
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        String selectedCommand = SavedCommandsFeature.this
                                .getSelectionModel().getSelectedItem().toString();
                        commandLineDrawer.setCommandLine(selectedCommand);
                    }
                }
            }
        });
    }

    /**
     * Adds the command in the command line to the list view. This method is called
     * when the SaveCommand button is clicked in the ButtonHolder component. Does
     * not add the command if command line is empty or command has already been saved.
     * @param currentCommand
     */
    public void addCommand (String currentCommand) {
        if(!currentCommand.isEmpty()){
            if(myCommands.stream().map(command->command.equals(currentCommand))
                    .filter(bool -> bool).toArray().length == 0){
                myCommands.add(currentCommand);
            }
        }
    }

    /**
     * Loads commands when user loads previously saved commands from an xml parser.
     * This is called when the user clicks file -> Load saved commands.
     * @param savedCommands
     */
    public void loadCommands (List<String> savedCommands) {
        for(String command:savedCommands){
            if(myCommands.stream().filter(c->c.equals(command)).count() == 0){
                myCommands.add(command);
            }
        }
    }

    public List<String> getCommands () {
        return myCommands;
    }   
}
