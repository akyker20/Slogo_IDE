package gui.mainclasses.workspace;

import gui.mainclasses.GUIController;
import gui.variableslist.WorkspaceVariable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Control.SlogoGraphics;
import XML.workspaceparams.DefaultWorkspaceParameters;
import XML.workspaceparams.WorkspaceParameters;

public class WorkspaceManager {
    public static Workspace activeWorkspace;
    private List<Workspace> myWorkspaces;
    private GUIController myGuiController;
    private SlogoGraphics myControl;
    private TabPane tabPane;
    //setting ID to start at 0 to allow index-access of TabPane children
    private static int workspaceID = 0;

    private int myWorkspaceID;

    public WorkspaceManager(GUIController guiControl, SlogoGraphics control)    {
        myGuiController = guiControl;
        myControl = control;
        myWorkspaces = new ArrayList<Workspace>();

        tabPane = new TabPane();      
        tabPane.getSelectionModel().selectedItemProperty().addListener(
                                                                       new ChangeListener<Tab>() {
                                                                           @Override
                                                                           public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                                                                               activeWorkspace = (Workspace) t1;
                                                                               System.out.println("Here 2\n");
                                                                           }
                                                                       }
                );   
        //tabPane.get;
        try {
            addWorkspace(new DefaultWorkspaceParameters(), new DefaultWorkspaceParameters(), new WorkspaceDataHolder());
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void addWorkspace(WorkspaceParameters screenParams, WorkspaceParameters penParams, 
                             WorkspaceDataHolder dataHolder) throws ParserConfigurationException, SAXException, IOException {
//        WorkspaceDataHolder dataHolder = new WorkspaceDataHolder(workspaceVariables, FXCollections.observableArrayList(), userDefinedCommands, savedCommands, FXCollections.observableArrayList());
        Workspace newWorkspace = new Workspace(myGuiController, myControl, screenParams, penParams, dataHolder);


        myWorkspaces.add(newWorkspace);
        tabPane.getTabs().add(newWorkspace); 
        //set active workspace as most most recently added workspace
        activeWorkspace = newWorkspace;
        newWorkspace.setText("Workspace " + workspaceID);
        //create corresponding workspace state object
        myControl.createWorkspaceState(workspaceID);
        myControl.setActiveWorkspaceState(myWorkspaceID);
        workspaceID++;     
    }

    public Workspace getActiveWorkspace() {
        return activeWorkspace;
    }

    public void setActiveWorkspace() {
        activeWorkspace = (Workspace) tabPane.getSelectionModel().getSelectedItem();
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}