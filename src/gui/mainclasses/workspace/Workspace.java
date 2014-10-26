package gui.mainclasses.workspace;

import gui.componentdrawers.ComponentBuilder;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.ObjectFactory;
import gui.factories.turtlefactory.TurtleNode;
import gui.factories.turtlefactory.TurtleNodes;
import gui.mainclasses.DrawableObjectParser;
import gui.mainclasses.FactoryBuilder;
import gui.mainclasses.FeatureBuilder;
import gui.mainclasses.StageInitializer;
import java.io.IOException;
import java.util.Map;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import Control.SlogoGraphics;
import XML.workspaceparams.WorkspaceScreenParameters;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

/**
 * Class manages a single workspace that hosts 
 * @author akyker20, allankiplagat
 *
 */
public class Workspace extends Tab {

    private SlogoGraphics myControl;
    private TurtleNodes myTurtleNodes;
    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private WorkspaceDataHolder myDataHolder;
    private TurtleScreenDrawer myTurtleScreenDrawer;
    private BorderPane myPane;
    private int myID;
    
    private static String FORWARD_COMMAND = "fd 10";
    private static String BACK_COMMAND = "bk 10";
    private static String RIGHT_COMMAND = "right 90";
    private static String LEFT_COMMAND = "left 90";

    public Workspace (SlogoGraphics control, WorkspaceScreenParameters screenParams,
                      WorkspaceDataHolder dataHolder, int id) {
        myControl = control;
        myDataHolder = dataHolder;
        myTurtleNodes = new TurtleNodes(this);
        myID = id;

        myPane = createPane();
        myComponentDrawers = ComponentBuilder.build(myPane, myTurtleNodes);
        myTurtleScreenDrawer = (TurtleScreenDrawer)
                myComponentDrawers.get(ComponentBuilder.SCREEN_DRAWER);
        myObjectFactories = FactoryBuilder
                .init(myDataHolder, myTurtleScreenDrawer, myTurtleNodes);
        FeatureBuilder.init(this, myComponentDrawers, screenParams, myDataHolder);
        setContent(myPane);
    }

    private BorderPane createPane () {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(StageInitializer.SCREEN_WIDTH, StageInitializer.SCREEN_HEIGHT);
        return pane;
    }

    public void parseCommandString (String command) {
        try {
            myControl.parseCommandString(command);
        }
        catch (CompileTimeParsingException | RunTimeDivideByZeroException
                | RunTimeNullPointerException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void moveActiveTurtles (KeyEvent event) {
        for (TurtleNode turtleNode : myTurtleNodes.getActiveNodes()) {
            String command = null;
            switch (event.getCode()) {
                case UP:
                    command = FORWARD_COMMAND;
                    break;
                case DOWN:
                    command = BACK_COMMAND;
                    break;
                case RIGHT:
                    command = RIGHT_COMMAND;
                    break;
                case LEFT:
                    command = LEFT_COMMAND;
                    break;
                default:
                    return;
            }
            try {
                myControl.parseCommandString(command);
            }
            catch (CompileTimeParsingException | RunTimeDivideByZeroException
                    | RunTimeNullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a command to the previous commands list view. Adds the command to the front
     * of the list so it will be displayed first in the view.
     *
     * @param command
     */
    public void addPreviousCommand (String command) {
        myDataHolder.getMyPreviousCommandsList().add(0, command);
    }

    /**
     * Clears the current workspace by removing the workspace variables
     * as well as the previous command log. This is called when the user
     * clicks the ClearWorkspace button feature in the options TabPane.
     */
    public void clear () {
        myDataHolder.clear();
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     *
     * @param objectQueue
     */
    public void parseDrawableObject (DrawableObject poll) {
        DrawableObjectParser.parseDrawableObject(poll, myComponentDrawers, myObjectFactories);
    }

    /**
     * When a turtle is selected, the back-end is made aware of the change.
     */
    public void notifyOfTurtleSelectionChange () {
        String activeTurtleStr = "";
        for (TurtleNode node : myTurtleNodes.getActiveNodes()) {
            activeTurtleStr += node.getTurtleID() + " ";
        }
        parseCommandString("Tell [ " + activeTurtleStr.trim() + " ]");
    }

    /**
     * Returns the workspace id of the workspace. This is necessary for the back-end
     * to know which workspace is selected.
     * @return
     */
    public int getWorkspaceID () {
        return myID;
    }

    /**
     * Returns the data holder. Used by the xml writer to write the workspace
     * configuration to a file for later use.
     * @return
     */
    public WorkspaceDataHolder getDataHolder () {
        return myDataHolder;
    }

    public WorkspaceScreenParameters getScreenParams () {
        return myTurtleScreenDrawer.getScreenParams();
    }
}
