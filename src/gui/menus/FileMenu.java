package gui.menus;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.mainclasses.TextGenerator;
import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.mainclasses.workspace.WorkspaceManager;
import gui.variableslist.WorkspaceVariable;
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
import Control.SlogoControl;
import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceScreenParameters;
import XML.writers.SavedWorkspaceXMLWriter;


/**
 * Class offers the user three major features.
 * 1) The user can load an xml file to load a workspace (variables, screen
 * parameters, pen parameters, etc.)
 * 2) The user can save the workspace to an xml file for later retrieval
 * 3) The user can create a new workspace - the user can do this in
 * several different languages to allow globalization.
 *
 * @author akyker20
 *
 */
public class FileMenu extends Menu {

    protected static final String SAVED_WORKSPACE_FILES_DIR = "./WorkspaceFiles";
    private static final String XML_FILE_EXTENSION_DESCRIPTION = "XML files (*.xml)";
    private static final String XML_FILE_EXTENSION = "*.xml";

    private WorkspaceManager myWorkspaceManager;

    public FileMenu (WorkspaceManager workspaceManager) {

        myWorkspaceManager = workspaceManager;

        setText(TextGenerator.get(TextGenerator.FILE));

        MenuItem loadWorkspace = new MenuItem(TextGenerator.get(TextGenerator.LOAD_WORKSPACE));
        loadWorkspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                try {
                    SavedWorkspaceXMLReader reader =
                            new SavedWorkspaceXMLReader(
                                                        createFileChooser(SAVED_WORKSPACE_FILES_DIR));
                    WorkspaceDataHolder dataHolder = reader.getWorkspaceDataHolder();
                    myWorkspaceManager.addWorkspace(reader.getScreenParameters(), dataHolder);
                    addTurtleToWorkspace();
                    for (String penCommand : reader.getInitialPenCommands()) {
                        myWorkspaceManager.getActiveWorkspace().parseCommandString(penCommand);
                    }

                    for (WorkspaceVariable variable : reader.getWorkspaceVariables()) {
                        String varStr = "set " + variable.getMyName() + " " + variable.getMyValue();
                        myWorkspaceManager.getActiveWorkspace().parseCommandString(varStr);
                    }

                    for (DisplayedUserCommand command : reader.getUserDefinedCommands()) {
                        String commandStr =
                                "to " + command.getMyName().trim() + " [ " +
                                        command.getMyParams().trim() + " ] [ " +
                                        command.getMyContent().trim() + " ]";
                        myWorkspaceManager.getActiveWorkspace().parseCommandString(commandStr);
                    }

                }
                catch (SAXException | IOException | ParserConfigurationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        MenuItem saveWorkspace = new MenuItem(TextGenerator.get(TextGenerator.SAVE_WORKSPACE));
        saveWorkspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {

                try {
                    SavedWorkspaceXMLWriter.writeFile(myWorkspaceManager.getActiveWorkspace()
                                                      .getDataHolder(),
                                                      myWorkspaceManager.getActiveWorkspace()
                                                      .getScreenParams());
                }
                catch (TransformerException | ParserConfigurationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Menu newWorkspace = new Menu(TextGenerator.get(TextGenerator.NEW_WORKSPACE));
        String[] languageOptions =
                new String[] { TextGenerator.ENGLISH, TextGenerator.FRENCH, TextGenerator.CHINESE };
        for (String language : languageOptions) {
            MenuItem languageMenuItem = new MenuItem(language);
            languageMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle (ActionEvent e) {
                    TextGenerator.setLanguage(language);
                    myWorkspaceManager.addWorkspace(new WorkspaceScreenParameters(),
                                                    new WorkspaceDataHolder());
                    myWorkspaceManager.getActiveWorkspace().parseCommandString("setlanguage /" +
                                                                               language);
                    addTurtleToWorkspace();
                }
            });
            newWorkspace.getItems().add(languageMenuItem);
        }

        getItems().addAll(loadWorkspace, saveWorkspace, newWorkspace);
    }

    private void addTurtleToWorkspace () {
        myWorkspaceManager.getActiveWorkspace().parseCommandString(SlogoControl.NEW_TURTLE_COMMAND);
    }

    /**
     * Creates the button used to select the XML file to run a simulation.
     * This will be the only button not disabled to start the simulation.
     *
     * @return
     */
    private File createFileChooser (String defaultDir) {
        FileChooser myFileChooser = new FileChooser();
        myFileChooser.setTitle(TextGenerator.get(TextGenerator.SELECT_XMLFILE));
        FileChooser.ExtensionFilter extentionFilter =
                new FileChooser.ExtensionFilter(
                                                XML_FILE_EXTENSION_DESCRIPTION, XML_FILE_EXTENSION);
        myFileChooser.getExtensionFilters().add(extentionFilter);
        myFileChooser.setInitialDirectory(new File(defaultDir));
        return myFileChooser.showOpenDialog(new Stage());
    }
}
