package gui.mainclasses.workspace;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceParameters;

public class WorkspaceManager {

    public static Workspace myActiveWorkspace;

    private static int workspaceID = 0;
    private List<Workspace> myWorkspaces;
    private SlogoGraphics myControl;
    private TabPane myTabPane;
    private int myWorkspaceID;

    public WorkspaceManager(SlogoGraphics control)    {
        myControl = control;
        myWorkspaces = new ArrayList<Workspace>();
        initializeTabPane(); 
        addWorkspace(new WorkspaceParameters(), new WorkspaceParameters(), new WorkspaceDataHolder());
    }

    private void initializeTabPane () {
        myTabPane = new TabPane();      
        myTabPane
        .getSelectionModel()
        .selectedItemProperty()
        .addListener(
                     new ChangeListener<Tab>() {
                         @Override
                         public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                             myActiveWorkspace = (Workspace) t1;
                         }
                     }
                );  
    }


    public void addWorkspace(WorkspaceParameters screenParams, 
                             WorkspaceParameters penParams, 
                             WorkspaceDataHolder dataHolder) {
       Workspace newWorkspace = new Workspace(myControl, screenParams, penParams, dataHolder);

        myWorkspaces.add(newWorkspace);
        myTabPane.getTabs().add(newWorkspace); 
        //set active workspace as most most recently added workspace
        myActiveWorkspace = newWorkspace;
        newWorkspace.setText("Workspace " + workspaceID);
        //create corresponding workspace state object
        myControl.createWorkspaceState(workspaceID);
        myControl.setActiveWorkspaceState(myWorkspaceID);
        workspaceID++;     
    }

    public Workspace getActiveWorkspace() {
        return myActiveWorkspace;
    }

    public void setActiveWorkspace() {
        myActiveWorkspace = (Workspace) myTabPane.getSelectionModel().getSelectedItem();
    }

    public TabPane getTabPane() {
        return myTabPane;
    }
}