package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.TurtleFactory;
import gui.factories.nodes.TurtleNodes;
import gui.variableslist.WorkspaceVariable;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeDivideByZeroException;
import commandParsing.exceptions.RunTimeNullPointerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Control.SlogoGraphics;
import drawableobject.DrawableObject;


/**
 * Class controls the GUI: initializes the scene and sets up the component
 * drawers, object factories, and features; depends on a SlogoGraphics control object
 *
 * @author allankiplagat, akyker20
 *
 */
public class GUIController {

    private DrawableObjectParser myParser;
    private Map<String, ComponentDrawer> myComponentDrawers;
    private ObjectFactory[] myObjectFactories;
    private BorderPane myPane;
    private ObservableList<WorkspaceVariable> myVariablesList;
    private ObservableList<String> myPreviousCommandsList;
    public static ResourceBundle GUI_TEXT;


    /**
     * Constructor that initializes GUI variables and features
     *
     * @param stage
     * @param control SlogoGraphics object that has access to GUI-related method calls
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */

    public GUIController (Stage stage, SlogoGraphics control) throws ParserConfigurationException, SAXException, IOException {
        GUI_TEXT = LocaleInitializer.init();
        final TurtleNodes turtleNodes = new TurtleNodes();
        myPane = StageInitializer.init(stage, control, turtleNodes);
        myComponentDrawers = ComponentInitializer.init(myPane, turtleNodes);
        myVariablesList = FXCollections.observableArrayList();
        myPreviousCommandsList = FXCollections.observableArrayList();
        myObjectFactories = FactoryInitializer.init(myVariablesList, (TurtleScreenDrawer) 
                                                    myComponentDrawers.get(ComponentInitializer.GRID_DRAWER),
                                                    turtleNodes);
        FeatureInitializer.init(myComponentDrawers, this, control, myVariablesList, myPreviousCommandsList);
        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);

    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     * @param objectQueue
     */
    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while (!objectQueue.isEmpty()) {
            myParser.parseDrawableObject(objectQueue.poll());
        }
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
}
