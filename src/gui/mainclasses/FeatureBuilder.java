package gui.mainclasses;

import gui.buttonfeatures.ClearWorkspaceButtonFeature;
import gui.buttonfeatures.SaveCommandButtonFeature;
import gui.buttonfeatures.ToggleGridButtonFeature;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentBuilder;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ErrorDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.componentdrawers.optionsholder.tabs.ColorIndexTab;
import gui.componentdrawers.optionsholder.tabs.GeneralOptionsTab;
import gui.componentdrawers.optionsholder.tabs.ImageIndexTab;
import gui.componentdrawers.optionsholder.tabs.OptionsTab;
import gui.componentdrawers.optionsholder.tabs.PenOptionsTab;
import gui.componentdrawers.significantcommands.SignificantCommandsDrawer;
import gui.componentdrawers.significantcommands.tabs.SavedCommandsTab;
import gui.componentdrawers.significantcommands.tabs.UserDefinedCommandsTab;
import gui.mainclasses.workspace.Workspace;
import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.nonbuttonfeatures.CommandLineFeature;
import gui.nonbuttonfeatures.ErrorDisplayFeature;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import gui.nonbuttonfeatures.SetTurtleScreenColorFeature;
import gui.nonbuttonfeatures.TurtleImageFeature;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import gui.nonbuttonfeatures.pen.PenColorPickerFeature;
import gui.nonbuttonfeatures.pen.PenThicknessSliderFeature;
import gui.nonbuttonfeatures.pen.PenUpOrDownFeature;
import gui.nonbuttonfeatures.tableviews.UserDefinedCommandsFeature;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndexFeature;
import gui.nonbuttonfeatures.tableviews.imageindex.ImageIndexFeature;
import gui.nonbuttonfeatures.tableviews.variables.WorkspaceVariablesFeature;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import XML.workspaceparams.WorkspaceScreenParameters;

/**
 * The purpose of this class is to initialize all of the features, both button features
 * and non-button features that will be displayed to the user.
 * @author Austin Kyker
 *
 */
public class FeatureBuilder {

    public static void init (Workspace workspace, Map<String, ComponentDrawer> drawerMap, WorkspaceScreenParameters screenParameters, WorkspaceDataHolder dataHolder) {

        
        TurtleScreenDrawer gridDrawer = (TurtleScreenDrawer) drawerMap.get(ComponentBuilder.SCREEN_DRAWER);
        OptionsHolderDrawer optionsHolder = 
                (OptionsHolderDrawer) drawerMap.get(ComponentBuilder.BUTTON_HOLDER_DRAWER);
        CommandLineDrawer commandLineDrawer = 
                (CommandLineDrawer) drawerMap.get(ComponentBuilder.COMMAND_LINE_DRAWER);
        PreviousCommandsDrawer previousCommandsDrawer = 
                (PreviousCommandsDrawer) drawerMap.get(ComponentBuilder.PREVIOUS_COMMANDS);
        SignificantCommandsDrawer significantCommandsDrawer = 
                (SignificantCommandsDrawer) drawerMap.get(ComponentBuilder.SIGNIFICANT_COMMANDS_DRAWER);
        WorkspaceVariablesDrawer workspaceVariablesDrawer = 
                (WorkspaceVariablesDrawer) drawerMap.get(ComponentBuilder.WORKSPACE_VARIABLES);
        ErrorDrawer errorDrawer = (ErrorDrawer) drawerMap.get(ComponentBuilder.ERROR_DRAWER);

        
            
        PreviousCommandsFeature previousCommandsFeature = new PreviousCommandsFeature(previousCommandsDrawer, commandLineDrawer,
                                                                                      dataHolder.getMyPreviousCommandsList());
        new CommandLineFeature(commandLineDrawer, workspace);
        new WorkspaceVariablesFeature(workspaceVariablesDrawer, dataHolder.getMyVariablesList(), workspace);
        SavedCommandsFeature savedCommandsFeature = new SavedCommandsFeature(commandLineDrawer, dataHolder.getMySavedCommandsList());
        new ErrorDisplayFeature(errorDrawer);    
        new TurtleScreenFeature(gridDrawer, screenParameters);

        
           
        
        GeneralOptionsTab generalOptions = 
                new GeneralOptionsTab(
                                      new Node[]{
                                                 new SetTurtleScreenColorFeature(gridDrawer, optionsHolder),   
                                                 new ToggleGridButtonFeature(gridDrawer, optionsHolder),
                                                 new SaveCommandButtonFeature(optionsHolder, commandLineDrawer, previousCommandsFeature, savedCommandsFeature),
                                                 new ClearWorkspaceButtonFeature(optionsHolder,workspace )
                                      }, 
                                      new Node[] {new TurtleImageFeature(optionsHolder, dataHolder.getMyImageIndexList())}
                        );

        PenOptionsTab penOptions = 
                new PenOptionsTab(
                                  new Node[]{
                                             new PenUpOrDownFeature(optionsHolder, workspace),
                                             new PenColorPickerFeature(optionsHolder, workspace),
                                             new PenThicknessSliderFeature(optionsHolder, workspace),
                },
                new Node[]{}
                );
        
        ColorIndexTab colorIndexTab = new ColorIndexTab(new ColorIndexFeature(dataHolder.getMyColorIndexList(), optionsHolder));

        ImageIndexTab imageIndexTab = new ImageIndexTab(new ImageIndexFeature(dataHolder.getMyImageIndexList(), optionsHolder));
        
        optionsHolder.addTabs(new OptionsTab[]{generalOptions, penOptions, colorIndexTab, imageIndexTab});

        significantCommandsDrawer.addTabs(new Tab[]{
                                                    new SavedCommandsTab(savedCommandsFeature),
                                                    new UserDefinedCommandsTab(new UserDefinedCommandsFeature(dataHolder.getMyUserDefinedCommandList()))    
        });
    }
}
