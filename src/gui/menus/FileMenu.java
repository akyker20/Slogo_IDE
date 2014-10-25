package gui.menus;

import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.mainclasses.workspace.WorkspaceManager;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceParameters;


/**
 * Class will be used to load files such as previously saved commands or
 * grid configurations.
 * @author Austin Kyker
 *
 */
public class FileMenu extends Menu {

    protected static final String SAVED_WORKSPACE_FILES_DIR = "./WorkspaceFiles";

    public FileMenu(WorkspaceManager workspaceManager)  {
        this.setText("File");


        MenuItem loadWorkspace = new MenuItem("Load Workspace");
        loadWorkspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    SavedWorkspaceXMLReader reader = new SavedWorkspaceXMLReader(createFileChooser(SAVED_WORKSPACE_FILES_DIR)); 
                    WorkspaceDataHolder dataHolder = reader.getWorkspaceDataHolder();
                    workspaceManager.addWorkspace(reader.getScreenParameters(), reader.getPenParams(), dataHolder);
                }
                catch (SAXException | IOException | ParserConfigurationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });


        MenuItem newWorkspace = new MenuItem("New Workspace");
        newWorkspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    workspaceManager.addWorkspace(new WorkspaceParameters(), new WorkspaceParameters(), 
                                                  new WorkspaceDataHolder());             
            }
        });

        this.getItems().addAll(loadWorkspace, newWorkspace);
    }

    /**
     * Creates the button used to select the XML file to run a simulation.
     * This will be the only button not disabled to start the simulation.
     * @return 
     */
    private File createFileChooser (String defaultDir) {
        FileChooser myFileChooser = new FileChooser();
        myFileChooser.setTitle("Select XML File");
        FileChooser.ExtensionFilter extentionFilter =
                new FileChooser.ExtensionFilter(
                                                "XML files (*.xml)", "*.xml");
        myFileChooser.getExtensionFilters().add(extentionFilter);
        myFileChooser.setInitialDirectory(new File(defaultDir));
        return myFileChooser.showOpenDialog(new Stage());
    }
}
