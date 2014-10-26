package gui.buttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.GuiTextGenerator;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;

public class SaveCommandButtonFeature extends ButtonFeature {

    private CommandLineDrawer myCommandLine;
    private PreviousCommandsFeature myPreviousCommands;
    private SavedCommandsFeature mySavedCommands;

    public SaveCommandButtonFeature(OptionsHolderDrawer parent, CommandLineDrawer commandLine, 
                                    PreviousCommandsFeature previousCommands, 
                                    SavedCommandsFeature savedCommands){
        super(GuiTextGenerator.CLEAR_WORKSPACE_TEXT, parent);
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
