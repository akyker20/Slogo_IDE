package gui.mainclasses.workspace;

import java.io.IOException;
import java.util.Map;
import java.util.Queue;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import drawableobject.DrawableObject;
import Control.SlogoGraphics;
import gui.commandlist.WorkspaceCommand;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.nodes.TurtleNodes;
import gui.mainclasses.DrawableObjectParser;
import gui.mainclasses.FeatureInitializer;
import gui.mainclasses.GUIController;
import gui.mainclasses.StageInitializer;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class Workspace extends Tab {

    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private ObservableList<WorkspaceVariable> myVariablesList;
    private ObservableList<WorkspaceCommand> myCommandList;
    private ObservableList<String> myPreviousCommandsList;
    private BorderPane myPane;

    public Workspace(GUIController guiControl, SlogoGraphics control) 
            throws ParserConfigurationException, SAXException, IOException{
        final TurtleNodes turtleNodes = new TurtleNodes();
        myPane = WorkspaceTabInitializer.init(control, turtleNodes);
        this.setContent(myPane);
        myComponentDrawers = ComponentInitializer.init(myPane, turtleNodes);
        myVariablesList = FXCollections.observableArrayList();
        myPreviousCommandsList = FXCollections.observableArrayList();
        
        myObjectFactories = FactoryInitializer.init(myVariablesList, myCommandList, (TurtleScreenDrawer) 
                myComponentDrawers.get(ComponentInitializer.GRID_DRAWER),
                turtleNodes);

        FeatureInitializer.init(myComponentDrawers, guiControl, control, myVariablesList, myPreviousCommandsList);
    }

    /**
     * Adds a command to the previous commands list view. Adds the command to the front
     * of the list so it will be displayed first in the view.
     * @param command
     */
    public void addPreviousCommand (String command) {
        myPreviousCommandsList.add(0, command);   
    }

    /**
     * Clears the current workspace by removing the workspace variables
     * as well as the previous command log. This is called when the user
     * clicks the ClearWorkspace button feature in the options TabPane.
     */
    public void clearCurrentWorkspace () {
        myVariablesList.clear();
        myPreviousCommandsList.clear();
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     * @param objectQueue
     */
    public void parseDrawableObject (DrawableObject poll) {
        DrawableObjectParser.parseDrawableObject(poll, myComponentDrawers, myObjectFactories);
    }
}