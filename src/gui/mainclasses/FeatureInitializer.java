package gui.mainclasses;

import gui.buttonfeatures.SaveCommandButtonFeature;
import gui.buttonfeatures.ToggleGridButtonFeature;
import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.ErrorDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.nonbuttonfeatures.CommandLineFeature;
import gui.nonbuttonfeatures.ErrorDisplayFeature;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import gui.nonbuttonfeatures.SetTurtleScreenColorFeature;
import gui.nonbuttonfeatures.WorkspaceVariablesFeature;
import gui.variableslist.WorkspaceVariable;
import java.util.Map;
import javafx.collections.ObservableList;
import Control.SlogoGraphics;


public class FeatureInitializer {

    public static void init (Map<String, ComponentDrawer> drawerMap, SlogoGraphics control, 
                             ObservableList<WorkspaceVariable> variablesList,
                             ObservableList<String> previousCommandsList ) {
        
        TurtleScreenDrawer gridDrawer = (TurtleScreenDrawer) drawerMap.get(ComponentInitializer.GRID_DRAWER);
        ButtonHolderDrawer buttonHolder = 
                (ButtonHolderDrawer) drawerMap.get(ComponentInitializer.BUTTON_HOLDER_DRAWER);
        CommandLineDrawer commandLineDrawer = 
                (CommandLineDrawer) drawerMap.get(ComponentInitializer.COMMAND_LINE_DRAWER);
        PreviousCommandsDrawer previousCommandsDrawer = 
                (PreviousCommandsDrawer) drawerMap.get(ComponentInitializer.PREVIOUS_COMMANDS);
        SavedCommandsDrawer savedCommandsDrawer = 
                (SavedCommandsDrawer) drawerMap.get(ComponentInitializer.SAVED_COMMANDS);
        WorkspaceVariablesDrawer workspaceVariablesDrawer = 
                (WorkspaceVariablesDrawer) drawerMap.get(ComponentInitializer.WORKSPACE_VARIABLES);
        
        ErrorDrawer errorDrawer = (ErrorDrawer) drawerMap.get(ComponentInitializer.ERROR_DRAWER);
        
        new SetTurtleScreenColorFeature(gridDrawer, buttonHolder);
        PreviousCommandsFeature previousCommandsFeature = new PreviousCommandsFeature(previousCommandsDrawer, commandLineDrawer,
                                                                                      previousCommandsList);
        new CommandLineFeature(commandLineDrawer, control);
        new ToggleGridButtonFeature(gridDrawer, buttonHolder);
        new WorkspaceVariablesFeature(workspaceVariablesDrawer, variablesList);
        
        SavedCommandsFeature savedCommandsFeature = new SavedCommandsFeature(savedCommandsDrawer, commandLineDrawer);
        new SaveCommandButtonFeature(buttonHolder, commandLineDrawer, previousCommandsFeature, savedCommandsFeature);
        
        new ErrorDisplayFeature(errorDrawer);
        new TurtleScreenFeature(gridDrawer);
        
    }
}
