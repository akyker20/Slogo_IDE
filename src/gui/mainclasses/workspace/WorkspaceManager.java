package gui.mainclasses.workspace;

import gui.mainclasses.GUIController;
import gui.variableslist.WorkspaceVariable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Control.SlogoGraphics;
import XML.workspaceparams.DefaultWorkspaceParameters;
import XML.workspaceparams.WorkspaceParameters;

public class WorkspaceManager {
    private Workspace activeWorkspace;
    private List<Workspace> myWorkspaces;
    private GUIController myGuiController;
    private SlogoGraphics myControl;
    private TabPane tabPane;
    
    private static int workspaceID = 1;

    public WorkspaceManager(GUIController guiControl, SlogoGraphics control) throws ParserConfigurationException, SAXException, IOException  {
        myGuiController = guiControl;
        myControl = control;
        myWorkspaces = new ArrayList<Workspace>();
        tabPane = new TabPane();     
        addWorkspace(new DefaultWorkspaceParameters(), new DefaultWorkspaceParameters(), FXCollections.observableArrayList(), FXCollections.observableArrayList(),
                     FXCollections.observableArrayList());
    }

    public void addWorkspace(WorkspaceParameters screenParams, WorkspaceParameters penParams, 
                             ObservableList<String> userDefinedCommands,
                             ObservableList<WorkspaceVariable> workspaceVariables,
                             ObservableList<String> savedCommands) throws ParserConfigurationException, SAXException, IOException {
        Workspace newWorkspace = new Workspace(myGuiController, myControl, screenParams, penParams, userDefinedCommands, workspaceVariables, savedCommands);
        myWorkspaces.add(newWorkspace);
        tabPane.getTabs().add(newWorkspace); 
        //set active workspace as most most recenty added workspace
        activeWorkspace = newWorkspace;
        newWorkspace.setText("Workspace " + workspaceID);
        workspaceID++;
    }
    
    public Workspace getActiveWorkspace() {
        return activeWorkspace;
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}