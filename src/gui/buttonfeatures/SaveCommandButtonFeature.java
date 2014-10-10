package gui.buttonfeatures;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import Control.SlogoGraphics;

public class SaveCommandButtonFeature extends ButtonFeature {
    public SaveCommandButtonFeature(ButtonHolderDrawer parent, CommandLineDrawer commandLine, SlogoGraphics control){
        super("saveCommand", parent);
        setOnAction(event -> control.saveCommand(commandLine.getCurrentCommand()));
    }
}
