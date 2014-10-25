package gui.mainclasses.workspace;

import gui.mainclasses.GUIController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TabPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import Control.SlogoGraphics;

public class WorkspaceManager {
    private Workspace activeWorkspace;
    private List<Workspace> myWorkspaces;
    private GUIController myGuiController;
    private SlogoGraphics myControl;
    private TabPane tabPane;

    private static int workspaceID = 1;

    private int myWorkspaceID;

    public WorkspaceManager(GUIController guiControl, SlogoGraphics control) throws ParserConfigurationException, SAXException, IOException, CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException  {
        myGuiController = guiControl;
        myControl = control;
        myWorkspaces = new ArrayList<Workspace>();
        tabPane = new TabPane();     
        addWorkspace();
    }

    public void addWorkspace() throws ParserConfigurationException, SAXException, IOException, CompileTimeParsingException, RunTimeDivideByZeroException, RunTimeNullPointerException {
        Workspace newWorkspace = new Workspace(myGuiController,myControl);
        myWorkspaces.add(newWorkspace);
        tabPane.getTabs().add(newWorkspace); 
        //set active workspace as most most recenty added workspace
        activeWorkspace = newWorkspace;
        newWorkspace.setText("Workspace " + workspaceID);
        workspaceID++;
        //place new turtle at (0,0)
        //myControl.parseCommandString("mk");
    }

    public Workspace getActiveWorkspace() {
        return activeWorkspace;
    }

    public TabPane getTabPane() {
        return tabPane;
    }
}