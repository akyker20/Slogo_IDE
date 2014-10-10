package gui.features;

import java.util.Map;
import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.GridDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import Control.SlogoGraphics;


public class FeatureInitializer {

    public static void init (Map<String, ComponentDrawer> drawerMap, SlogoGraphics control) {
        GridDrawer gridDrawer = (GridDrawer) drawerMap.get(ComponentInitializer.GRID_DRAWER);
        ButtonHolderDrawer buttonHolder = 
                (ButtonHolderDrawer) drawerMap.get(ComponentInitializer.BUTTON_HOLDER_DRAWER);
        CommandLineDrawer commandLineDrawer = 
                (CommandLineDrawer) drawerMap.get(ComponentInitializer.COMMAND_LINE_DRAWER);
        PreviousCommandsDrawer previousCommands = 
                (PreviousCommandsDrawer) drawerMap.get(ComponentInitializer.PREVIOUS_COMMANDS);
        SavedCommandsDrawer savedCommands = 
                (SavedCommandsDrawer) drawerMap.get(ComponentInitializer.SAVED_COMMANDS);
        WorkspaceVariablesDrawer workspaceVariables = 
                (WorkspaceVariablesDrawer) drawerMap.get(ComponentInitializer.WORKSPACE_VARIABLES);
        
        new SetGridColorFeature(gridDrawer, buttonHolder);
        new CommandLineFeature(commandLineDrawer, control);
        new ToggleRelativeGridFeature(gridDrawer, buttonHolder);
        new PreviousCommandsFeature(previousCommands, control);
        new WorkspaceVariablesFeature(workspaceVariables);
        new SavedCommandsFeature(savedCommands, control);
        new GridFeature(gridDrawer);
    }
}
