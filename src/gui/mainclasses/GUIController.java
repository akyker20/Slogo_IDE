package gui.mainclasses;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.ComponentInitializer;
import gui.componentdrawers.TurtleScreenDrawer;
import gui.factories.FactoryInitializer;
import gui.factories.ObjectFactory;
import gui.factories.TurtleFactory;
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
    public static ResourceBundle GUI_TEXT;
    public static Stage GUI_STAGE;


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
        GUI_STAGE = stage;
        GUI_TEXT = LocaleInitializer.init();
        myPane = StageInitializer.init(GUI_STAGE);
        myPane.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override public void handle(KeyEvent event) {
                if(TurtleFactory.isTurtleSelected()){
                    String command = null;
                    switch(event.getCode()){
                        case UP: command = "fd 10"; break;
                        case DOWN: command = "bk 10"; break;
                        case RIGHT: command = "right 90"; break;
                        case LEFT: command = "left 90"; break;
                    }
                    try {
                        control.parseCommandString(command);
                    }
                    catch (CompileTimeParsingException | RunTimeDivideByZeroException
                            | RunTimeNullPointerException | IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        myComponentDrawers = ComponentInitializer.init(myPane);

        final ObservableList<WorkspaceVariable> variablesList = FXCollections.observableArrayList();
        myObjectFactories = FactoryInitializer.init(variablesList, (TurtleScreenDrawer) myComponentDrawers.get(ComponentInitializer.GRID_DRAWER));
        FeatureInitializer.init(myComponentDrawers, control, variablesList);

        myParser = new DrawableObjectParser(myComponentDrawers, myObjectFactories);

    }

    /**
     * Method to convert a DrawableObject queue into shapes that can be drawn on the screen
     *
     * @param objectQueue
     */
    public void drawDrawableObjects (Queue<DrawableObject> objectQueue) {
        while (!objectQueue.isEmpty()) {
            myParser.parseDrawableObject(objectQueue.poll());
        }

    }
}
