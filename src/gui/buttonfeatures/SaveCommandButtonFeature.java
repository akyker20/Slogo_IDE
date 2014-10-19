package gui.buttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import Control.SlogoGraphics;

public class SaveCommandButtonFeature extends ButtonFeature {

    private CommandLineDrawer myCommandLine;
    private PreviousCommandsFeature myPreviousCommands;
    private SavedCommandsFeature mySavedCommands;

    public SaveCommandButtonFeature(ButtonHolderDrawer parent, CommandLineDrawer commandLine, 
                                    PreviousCommandsFeature previousCommands, 
                                    SavedCommandsFeature savedCommands){
        super("saveCommand", parent);
        myCommandLine = commandLine;
        myPreviousCommands = previousCommands;
        mySavedCommands = savedCommands;

        setOnAction(event -> saveCommand());
    }

    private void saveCommand () {
        String currentCommandLineCommand = myCommandLine.getCurrentCommand();
        if(!myPreviousCommands.getSelectionModel().isEmpty()){
            mySavedCommands.addCommand(myPreviousCommands.getSelectionModel().getSelectedItem().toString()); 
            myPreviousCommands.getSelectionModel().clearSelection();
        }
        else if(!currentCommandLineCommand.isEmpty()){
            mySavedCommands.addCommand(currentCommandLineCommand); 
        }
    }
}
