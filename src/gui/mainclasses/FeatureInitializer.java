package gui.mainclasses;

import gui.buttonfeatures.ClearWorkspaceButtonFeature;
import gui.buttonfeatures.SaveCommandButtonFeature;
import gui.buttonfeatures.ToggleGridButtonFeature;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.ErrorDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import gui.componentdrawers.SavedCommandsDrawer;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import gui.componentdrawers.buttonholder.tabs.GeneralOptionsTab;
import gui.componentdrawers.buttonholder.tabs.OptionsTab;
import gui.componentdrawers.buttonholder.tabs.PenOptionsTab;
import gui.nonbuttonfeatures.CommandLineFeature;
import gui.nonbuttonfeatures.ErrorDisplayFeature;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import gui.nonbuttonfeatures.SetTurtleScreenColorFeature;
import gui.nonbuttonfeatures.workspacevariables.WorkspaceVariablesFeature;
import gui.variableslist.WorkspaceVariable;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import Control.SlogoGraphics;


public class FeatureInitializer {

    public static void init (Map<String, ComponentDrawer> drawerMap, GUIController guiController, SlogoGraphics control, 
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
        
        PreviousCommandsFeature previousCommandsFeature = new PreviousCommandsFeature(previousCommandsDrawer, commandLineDrawer,
                                                                                      previousCommandsList);
        new CommandLineFeature(commandLineDrawer, control);
        new WorkspaceVariablesFeature(workspaceVariablesDrawer, variablesList, control);
        
        SavedCommandsFeature savedCommandsFeature = new SavedCommandsFeature(savedCommandsDrawer, commandLineDrawer);
        
        new ErrorDisplayFeature(errorDrawer);
        new TurtleScreenFeature(gridDrawer);
        
        GeneralOptionsTab generalOptions = new GeneralOptionsTab(new Node[]{
            new SetTurtleScreenColorFeature(gridDrawer, buttonHolder),   
            new ToggleGridButtonFeature(gridDrawer, buttonHolder),
            new SaveCommandButtonFeature(buttonHolder, commandLineDrawer, previousCommandsFeature, savedCommandsFeature),
            new ClearWorkspaceButtonFeature(buttonHolder, guiController)
        });
        
        PenOptionsTab penOptions = new PenOptionsTab(new Node[]{});
        
        buttonHolder.addTabs(new OptionsTab[]{generalOptions, penOptions});
        
    }
}
