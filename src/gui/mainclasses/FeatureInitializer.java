package gui.mainclasses;

import gui.buttonfeatures.ClearWorkspaceButtonFeature;
import gui.buttonfeatures.SaveCommandButtonFeature;
import gui.buttonfeatures.ToggleGridButtonFeature;
import gui.componentdrawers.CommandLineDrawer;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.ErrorDrawer;
import gui.componentdrawers.PreviousCommandsDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.componentdrawers.WorkspaceVariablesDrawer;
import gui.componentdrawers.optionsholder.OptionsHolderDrawer;
import gui.componentdrawers.optionsholder.tabs.ColorIndexTab;
import gui.componentdrawers.optionsholder.tabs.GeneralOptionsTab;
import gui.componentdrawers.optionsholder.tabs.OptionsTab;
import gui.componentdrawers.optionsholder.tabs.PenOptionsTab;
import gui.componentdrawers.significantcommands.SignificantCommandsDrawer;
import gui.componentdrawers.significantcommands.tabs.SavedCommandsTab;
import gui.componentdrawers.significantcommands.tabs.UserDefinedCommandsTab;
import gui.nonbuttonfeatures.CommandLineFeature;
import gui.nonbuttonfeatures.ErrorDisplayFeature;
import gui.nonbuttonfeatures.PreviousCommandsFeature;
import gui.nonbuttonfeatures.SavedCommandsFeature;
import gui.nonbuttonfeatures.SetTurtleScreenColorFeature;
import gui.nonbuttonfeatures.TurtleImageFeature;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import gui.nonbuttonfeatures.UserDefinedCommandsFeature;
import gui.nonbuttonfeatures.pen.PenColorPickerFeature;
import gui.nonbuttonfeatures.pen.PenThicknessSliderFeature;
import gui.nonbuttonfeatures.pen.PenTypeFeature;
import gui.nonbuttonfeatures.pen.PenUpOrDownFeature;
import gui.nonbuttonfeatures.tableviews.ColorIndex;
import gui.nonbuttonfeatures.tableviews.ColorIndexFeature;
import gui.nonbuttonfeatures.tableviews.WorkspaceVariablesFeature;
import gui.variableslist.WorkspaceVariable;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceParameters;

/**
 * The purpose of this class is to initialize all of the features, both button features
 * and non-button features that will be displayed to the user.
 * @author Austin Kyker
 *
 */
public class FeatureInitializer {

    public static void init (Map<String, ComponentDrawer> drawerMap, GUIController guiController, SlogoGraphics control, 
                             ObservableList<WorkspaceVariable> workspaceVariables,
                             ObservableList<String> previousCommandsList, WorkspaceParameters screenParameters,
                             ObservableList<String> userDefinedCommands,
                             ObservableList<String> savedCommands,
                             ObservableList<ColorIndex> colorIndexList) {

        TurtleScreenDrawer gridDrawer = (TurtleScreenDrawer) drawerMap.get(ComponentInitializer.GRID_DRAWER);
        OptionsHolderDrawer buttonHolder = 
                (OptionsHolderDrawer) drawerMap.get(ComponentInitializer.BUTTON_HOLDER_DRAWER);
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

        new WorkspaceVariablesFeature(workspaceVariablesDrawer, workspaceVariables, control);

        SavedCommandsFeature savedCommandsFeature = new SavedCommandsFeature(commandLineDrawer, savedCommands);



        new ErrorDisplayFeature(errorDrawer);
        new TurtleScreenFeature(gridDrawer, screenParameters);

        GeneralOptionsTab generalOptions = 
                new GeneralOptionsTab(
                                      new Node[]{
                                                 new SetTurtleScreenColorFeature(gridDrawer, buttonHolder),   
                                                 new ToggleGridButtonFeature(gridDrawer, buttonHolder),
                                                 new SaveCommandButtonFeature(buttonHolder, commandLineDrawer, previousCommandsFeature, savedCommandsFeature),
                                                 new ClearWorkspaceButtonFeature(buttonHolder, guiController)
                                      }, 
                                      new Node[] {new TurtleImageFeature(buttonHolder)}
                        );

        PenOptionsTab penOptions = 
                new PenOptionsTab(new Node[]{
                                             new PenUpOrDownFeature(buttonHolder, control),
                                             new PenTypeFeature(buttonHolder, control),
                                             new PenColorPickerFeature(buttonHolder, control),
                                             new PenThicknessSliderFeature(buttonHolder, control),
                },
                new Node[]{}
                );
        
        ColorIndexTab colorIndexTab = new ColorIndexTab(new ColorIndexFeature(colorIndexList, buttonHolder));

        buttonHolder.addTabs(new OptionsTab[]{generalOptions, penOptions, colorIndexTab});

        significantCommandsDrawer.addTabs(new Tab[]{
                                                    new SavedCommandsTab(savedCommandsFeature),
                                                    new UserDefinedCommandsTab(new UserDefinedCommandsFeature(userDefinedCommands))    
        });
    }
}
