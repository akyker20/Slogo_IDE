package gui.mainclasses.workspace;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceParameters;

public class WorkspaceManager extends TabPane {

    public static Workspace myActiveWorkspace;

    private static int workspaceID = 0;

    private SlogoGraphics myControl;
    private int myWorkspaceID;

    public WorkspaceManager(SlogoGraphics control)    {
        myControl = control;
        initializeTabPane(); 
        addWorkspace(new WorkspaceParameters(), new WorkspaceParameters(), 
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

    public void addWorkspace(WorkspaceParameters screenParams, 
                             WorkspaceParameters penParams, 
                             WorkspaceDataHolder dataHolder) {
        Workspace newWorkspace = new Workspace(myControl, screenParams, penParams, dataHolder, workspaceID);
        newWorkspace.setText("Workspace " + workspaceID);
        
        getTabs().add(newWorkspace); 
        myActiveWorkspace = newWorkspace;
        myControl.createWorkspaceState(workspaceID);
        myControl.setActiveWorkspaceState(myWorkspaceID);
        workspaceID++;     
    }

    public Workspace getActiveWorkspace() {
        return myActiveWorkspace;
    }
}