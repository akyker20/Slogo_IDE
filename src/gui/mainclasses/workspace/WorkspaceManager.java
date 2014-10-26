package gui.mainclasses.workspace;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspacePenCommands;
import XML.workspaceparams.WorkspaceScreenParameters;

public class WorkspaceManager extends TabPane {

    private static final String NEW_TURTLE_COMMAND = "mk";

    public static Workspace myActiveWorkspace;

    private static int workspaceID = 0;

    private SlogoGraphics myControl;
    private int myWorkspaceID;

    public WorkspaceManager(SlogoGraphics control)    {
        myControl = control;
        initializeTabPane(); 
        addWorkspace(new WorkspaceScreenParameters(), new WorkspacePenCommands(), 
                     new WorkspaceDataHolder());
    }

    private void initializeTabPane () {    
        this
        .getSelectionModel()
        .selectedItemProperty()
        .addListener(
                     new ChangeListener<Tab>() {
                         @Override
                         public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                             myActiveWorkspace = (Workspace) t1;
                             myControl.setActiveWorkspaceState(myActiveWorkspace.getWorkspaceID());
                             System.out.println(myActiveWorkspace.getWorkspaceID());
                         }
                     }
                );  
    }

    public void addWorkspace(WorkspaceScreenParameters screenParams, 
                             WorkspacePenCommands penCommandsList, 
                             WorkspaceDataHolder dataHolder) {
        Workspace newWorkspace = new Workspace(myControl, screenParams, dataHolder, workspaceID);
        newWorkspace.setText("Workspace " + workspaceID);
        
        getTabs().add(newWorkspace); 
        myActiveWorkspace = newWorkspace;
        myActiveWorkspace.setInitialPenConfiguration(penCommandsList);
        myControl.createWorkspaceState(workspaceID);
        myControl.setActiveWorkspaceState(myWorkspaceID);
        workspaceID++;   
    }

    public Workspace getActiveWorkspace() {
        return myActiveWorkspace;
    }
}