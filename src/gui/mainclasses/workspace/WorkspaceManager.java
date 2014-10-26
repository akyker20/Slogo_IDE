package gui.mainclasses.workspace;

import gui.mainclasses.GuiTextGenerator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceScreenParameters;

public class WorkspaceManager extends TabPane {

    public static Workspace myActiveWorkspace;

    private static int workspaceID = 0;

    private SlogoGraphics myControl;

    public WorkspaceManager(SlogoGraphics control)    {
        myControl = control;
        initializeTabPane(); 
        addWorkspace(new WorkspaceScreenParameters(), new WorkspaceDataHolder());
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
                         }
                     }
                );  
    }

    public void addWorkspace(WorkspaceScreenParameters screenParams,  
                             WorkspaceDataHolder dataHolder) {
        Workspace newWorkspace = new Workspace(myControl, screenParams, dataHolder, workspaceID);
        newWorkspace.setText(GuiTextGenerator.get(GuiTextGenerator.WORKSPACE_LABEL_TEXT)+" " + workspaceID);
        
        getTabs().add(newWorkspace); 
        myActiveWorkspace = newWorkspace;
        myControl.createWorkspaceState(workspaceID);
        myControl.setActiveWorkspaceState(workspaceID);
        workspaceID++;
    }

    public Workspace getActiveWorkspace() {
        return myActiveWorkspace;
    }
}