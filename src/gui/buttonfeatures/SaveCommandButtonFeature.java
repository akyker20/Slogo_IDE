package gui.buttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import Control.SlogoGraphics;

public class SaveCommandButtonFeature extends ButtonFeature {
    public SaveCommandButtonFeature(ButtonHolderDrawer parent, CommandLineDrawer commandLine, SavedCommandsFeature savedCommands){
        super("saveCommand", parent);
        setOnAction(event -> savedCommands.addCommand(commandLine.getCurrentCommand()));
    }
}
