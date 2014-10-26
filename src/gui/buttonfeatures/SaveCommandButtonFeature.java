package gui.buttonfeatures;

import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.mainclasses.TextGenerator;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;


/**
 * This class allows the user to save a command for future use. Commands can
 * be saved from the command line or from the previous commands list view.
 *
 * @author Austin Kyker
 *
 */
public class SaveCommandButtonFeature extends ButtonFeature {

    private CommandLineDrawer myCommandLine;
    private PreviousCommandsFeature myPreviousCommands;
    private SavedCommandsFeature mySavedCommands;

    public SaveCommandButtonFeature (OptionsHolderDrawer parent, CommandLineDrawer commandLine,
                                     PreviousCommandsFeature previousCommands,
                                     SavedCommandsFeature savedCommands) {
        super(TextGenerator.SAVE_COMMAND, parent);
        myCommandLine = commandLine;
        myPreviousCommands = previousCommands;
        mySavedCommands = savedCommands;

        setOnAction(event -> saveCommand());
    }

    /**
     * First, checks to see if the user is trying to select a command from the previous
     * command line (this is the case if one of the previous commands list view items
     * is selected). Otherwise, the command to be saved is taken from the commandline.
     */
    private void saveCommand () {
        String currentCommandLineCommand = myCommandLine.getCurrentCommand();
        if (!myPreviousCommands.getSelectionModel().isEmpty()) {
            mySavedCommands.addCommand(myPreviousCommands.getSelectionModel().getSelectedItem()
                                       .toString());
            myPreviousCommands.getSelectionModel().clearSelection();
        }
        else if (!currentCommandLineCommand.isEmpty()) {
            mySavedCommands.addCommand(currentCommandLineCommand);
        }
    }
}
