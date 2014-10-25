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
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.componentdrawers.buttonholder.ButtonHolderDrawer;
import gui.componentdrawers.buttonholder.tabs.GeneralOptionsTab;
import gui.componentdrawers.buttonholder.tabs.OptionsTab;
import gui.componentdrawers.buttonholder.tabs.PenOptionsTab;
import gui.componentdrawers.significantcommands.SignificantCommandsDrawer;
import gui.componentdrawers.significantcommands.tabs.SavedCommandsTab;
import gui.nonbuttonfeatures.CommandLineFeature;
import gui.nonbuttonfeatures.ErrorDisplayFeature;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import gui.nonbuttonfeatures.SetTurtleScreenColorFeature;
import gui.nonbuttonfeatures.pen.PenColorPickerFeature;
import gui.nonbuttonfeatures.pen.PenThicknessSliderFeature;
import gui.nonbuttonfeatures.pen.PenTypeFeature;
import gui.nonbuttonfeatures.pen.PenUpOrDownFeature;
import gui.nonbuttonfeatures.workspacevariables.WorkspaceVariablesFeature;
import gui.variableslist.WorkspaceVariable;
import java.util.Map;
import XML.workspaceparams.WorkspaceParameters;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import Control.SlogoGraphics;

/**
 * The purpose of this class is to initialize all of the features, both button features
 * and non-button features that will be displayed to the user.
 * @author Austin Kyker
 *
 */
public class FeatureInitializer {

    public static void init (Map<String, ComponentDrawer> drawerMap, GUIController guiController, SlogoGraphics control, 
                             ObservableList<WorkspaceVariable> variablesList,
                             ObservableList<String> previousCommandsList, WorkspaceParameters screenParameters ) {
        
        TurtleScreenDrawer gridDrawer = (TurtleScreenDrawer) drawerMap.get(ComponentInitializer.GRID_DRAWER);
        ButtonHolderDrawer buttonHolder = 
                (ButtonHolderDrawer) drawerMap.get(ComponentInitializer.BUTTON_HOLDER_DRAWER);
        CommandLineDrawer commandLineDrawer = 
                (CommandLineDrawer) drawerMap.get(ComponentInitializer.COMMAND_LINE_DRAWER);
        PreviousCommandsDrawer previousCommandsDrawer = 
                (PreviousCommandsDrawer) drawerMap.get(ComponentInitializer.PREVIOUS_COMMANDS);
        SignificantCommandsDrawer significantCommandsDrawer = 
                (SignificantCommandsDrawer) drawerMap.get(ComponentInitializer.SIGNIFICANT_COMMANDS_DRAWER);
        WorkspaceVariablesDrawer workspaceVariablesDrawer = 
                (WorkspaceVariablesDrawer) drawerMap.get(ComponentInitializer.WORKSPACE_VARIABLES);
        
        ErrorDrawer errorDrawer = (ErrorDrawer) drawerMap.get(ComponentInitializer.ERROR_DRAWER);
        
        PreviousCommandsFeature previousCommandsFeature = new PreviousCommandsFeature(previousCommandsDrawer, commandLineDrawer,
                                                                                      previousCommandsList);
        new CommandLineFeature(commandLineDrawer, control);
        new WorkspaceVariablesFeature(workspaceVariablesDrawer, variablesList, control);
        
        SavedCommandsFeature savedCommandsFeature = new SavedCommandsFeature(commandLineDrawer);
        
        
        SavedCommandsTab savedCommandsTab = new SavedCommandsTab(savedCommandsFeature);
        
        
        
        new ErrorDisplayFeature(errorDrawer);
        new TurtleScreenFeature(gridDrawer, screenParameters);
        
        GeneralOptionsTab generalOptions = new GeneralOptionsTab(new Node[]{
            new SetTurtleScreenColorFeature(gridDrawer, buttonHolder),   
            new ToggleGridButtonFeature(gridDrawer, buttonHolder),
            new SaveCommandButtonFeature(buttonHolder, commandLineDrawer, previousCommandsFeature, savedCommandsFeature),
            new ClearWorkspaceButtonFeature(buttonHolder, guiController)
        });
        
        PenOptionsTab penOptions = new PenOptionsTab(new Node[]{
            new PenUpOrDownFeature(buttonHolder, control),
            new PenTypeFeature(buttonHolder, control),
            new PenColorPickerFeature(buttonHolder, control),
            new PenThicknessSliderFeature(buttonHolder, control),
        });
        
        buttonHolder.addTabs(new OptionsTab[]{generalOptions, penOptions});
        
        significantCommandsDrawer.addTabs(new Tab[]{savedCommandsTab});
        
    }
}
