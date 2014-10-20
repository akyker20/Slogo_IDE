package gui.menus;

import gui.componentdrawers.SavedCommandsDrawer;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import XML.SavedCommandsXMLReader;
import XML.SavedCommandsXMLWriter;

/**
 * Class will be used to load files such as previously saved commands or
 * grid configurations.
 * @author Austin Kyker
 *
 */
public class FileMenu extends Menu {
    
    private static final String SAVED_COMMAND_FILES_DIR = "./savedcommands";

    public FileMenu(SavedCommandsDrawer savedCommandsDrawer) throws ParserConfigurationException, SAXException, IOException {
        this.setText("File");
        
        //use Lambda notation and make these open HTML help pages...
        MenuItem loadGrid = new MenuItem("Load Grid");
        loadGrid.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Code to open previous grid config...");
            }
        });
        MenuItem loadCommands = new MenuItem("Load Commands");
        loadCommands.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    savedCommandsDrawer.loadCommands(SavedCommandsXMLReader.getSavedCommands(createFileChooser()));
                }
                catch (SAXException | IOException | ParserConfigurationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        MenuItem saveCommands = new MenuItem("Save Commands");
        saveCommands.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    SavedCommandsXMLWriter.writeFile(savedCommandsDrawer.getCommands());
                }
                catch (TransformerException | ParserConfigurationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        this.getItems().addAll(loadGrid, loadCommands, saveCommands);
    }
    
    /**
     * Creates the button used to select the XML file to run a simulation.
     * This will be the only button not disabled to start the simulation.
     * @return 
     */
    private File createFileChooser () {
        FileChooser myFileChooser = new FileChooser();
        myFileChooser.setTitle("Select XML File");
        FileChooser.ExtensionFilter extentionFilter =
                new FileChooser.ExtensionFilter(
                                                "XML files (*.xml)", "*.xml");
        myFileChooser.getExtensionFilters().add(extentionFilter);
        myFileChooser.setInitialDirectory(new File(SAVED_COMMAND_FILES_DIR));
        return myFileChooser.showOpenDialog(new Stage());
    }
}
