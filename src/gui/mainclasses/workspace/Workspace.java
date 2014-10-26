package gui.mainclasses.workspace;

import gui.componentdrawers.ComponentBuilder;
import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.FactoryBuilder;
import gui.factories.ObjectFactory;
import gui.factories.turtlefactory.TurtleNode;
import gui.factories.turtlefactory.TurtleNodes;
import gui.mainclasses.DrawableObjectParser;
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

public class Workspace extends Tab {
    
    private SlogoGraphics myControl;
    private TurtleNodes myTurtleNodes;
    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private WorkspaceDataHolder myDataHolder;
    private BorderPane myPane;
    private int myID;

    public Workspace(SlogoGraphics control, WorkspaceScreenParameters screenParams, 
                     WorkspaceDataHolder dataHolder, int id) {
        myControl = control;
        myDataHolder = dataHolder;
        myTurtleNodes = new TurtleNodes(this);
        myID = id; 
        
        myPane = createPane();
        myComponentDrawers = ComponentBuilder.build(myPane, myTurtleNodes);
        myObjectFactories = FactoryBuilder
                .init(myDataHolder, (TurtleScreenDrawer) 
                      myComponentDrawers.get(ComponentBuilder.SCREEN_DRAWER), myTurtleNodes);
        FeatureBuilder.init(this, myComponentDrawers, screenParams, myDataHolder);        
        this.setContent(myPane);
    }

    private BorderPane createPane() {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(StageInitializer.SCREEN_WIDTH, StageInitializer.SCREEN_HEIGHT);
        return pane;
    }

    public void parseCommandString(String command) {
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

    /**
     * Adds a command to the previous commands list view. Adds the command to the front
     * of the list so it will be displayed first in the view.
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
    public void clear() {
        myDataHolder.clear();
    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     * @param objectQueue
     */
    public void parseDrawableObject (DrawableObject poll) {
        DrawableObjectParser.parseDrawableObject(poll, myComponentDrawers, myObjectFactories);
    }

    public void notifyOfTurtleSelectionChange () {
        String activeTurtleStr = "";
        for(TurtleNode node:myTurtleNodes.getActiveNodes()){
            activeTurtleStr += node.getTurtleID() + " ";
        }
        parseCommandString("Tell [ " + activeTurtleStr.trim() + " ]");
    }

    public int getWorkspaceID () {
        return myID;
    }

    public WorkspaceDataHolder getDataHolder () {
        return myDataHolder;
    }
}