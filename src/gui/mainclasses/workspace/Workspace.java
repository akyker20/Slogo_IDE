package gui.mainclasses.workspace;

import gui.commandlist.WorkspaceCommand;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.nodes.TurtleNode;
import gui.factories.nodes.TurtleNodes;
import gui.mainclasses.DrawableObjectParser;
import gui.mainclasses.FeatureInitializer;
import gui.mainclasses.GUIController;
import gui.variableslist.WorkspaceVariable;
import java.io.IOException;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceParameters;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public class Workspace extends Tab {

    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private ObservableList<WorkspaceVariable> myVariablesList;
    private ObservableList<WorkspaceCommand> myCommandList;
    private ObservableList<String> myPreviousCommandsList;
    private ObservableList<String> myUserDefinedCommandList;
    private ObservableList<String> mySavedCommandsList;
    private BorderPane myPane;
    private SlogoGraphics myControl;
    private TurtleNodes myTurtleNodes;
    public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final String STYLESHEET_PACKAGE = "Stylesheets/";


    public Workspace(GUIController guiControl, SlogoGraphics control, WorkspaceParameters screenParams, 
                     WorkspaceParameters penParams, ObservableList<String> userDefinedCommands,
                     ObservableList<WorkspaceVariable> workspaceVariables,
                     ObservableList<String> savedCommands)
                             throws ParserConfigurationException, SAXException, IOException{
        myControl = control;
        myTurtleNodes = new TurtleNodes();
        myPane = createPane();
        this.setContent(myPane);
        myComponentDrawers = ComponentInitializer.init(myPane, myTurtleNodes);
        myVariablesList = workspaceVariables;
        myPreviousCommandsList = FXCollections.observableArrayList();
        myUserDefinedCommandList = userDefinedCommands;
        mySavedCommandsList = savedCommands;

        myObjectFactories = FactoryInitializer.init(myVariablesList, myCommandList, (TurtleScreenDrawer) 
                                                    myComponentDrawers.get(ComponentInitializer.GRID_DRAWER),
                                                    myTurtleNodes);

        FeatureInitializer.init(myComponentDrawers, guiControl, control, myVariablesList, myPreviousCommandsList, screenParams, myUserDefinedCommandList, mySavedCommandsList);
    }

    private BorderPane createPane() {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        pane.setOnKeyReleased(event->moveActiveTurtles(event));
        return pane;
    }

    private void moveActiveTurtles (KeyEvent event) {
        for(TurtleNode turtleNode:myTurtleNodes.getActiveNodes()){
            String command = null;
            switch(event.getCode()){
                case UP: command = "fd 10"; break;
                case DOWN: command = "bk 10"; break;
                case RIGHT: command = "right 90"; break;
                case LEFT: command = "left 90"; break;
                default:
                    return;
            }
            try {
                myControl.parseCommandString(command);
            }
            catch (CompileTimeParsingException | RunTimeDivideByZeroException
                    | RunTimeNullPointerException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Map<String, ComponentDrawer> getComponentDrawers() {
        return myComponentDrawers;
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
        myUserDefinedCommandList.clear();
        mySavedCommandsList.clear();
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     * @param objectQueue
     */
    public void parseDrawableObject (DrawableObject poll) {
        DrawableObjectParser.parseDrawableObject(poll, myComponentDrawers, myObjectFactories);
    }
}