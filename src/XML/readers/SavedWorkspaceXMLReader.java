package XML.readers;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.variableslist.WorkspaceVariable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import XML.workspaceparams.WorkspacePenCommands;
import XML.workspaceparams.WorkspaceScreenParameters;

/**
 * The purpose of this class is to read workspace configurations from an
 * xml file.
 * @author Austin Kyker
 *
 */
public class SavedWorkspaceXMLReader {

    private static final String SET_FIRST_PALETTE_INDEX = "setpalette 0 ";
    private static final String SET_PEN_COLOR = "setpencolor 0";
    public static final String COMMAND = "command";
    public static final String SCREEN = "screen";
    public static final String COLOR = "color";
    public static final String TOGGLE_GRID = "toggleGrid";
    public static final String TRUE = "true";
    public static final String PIXELS = "pixels";
    public static final String USER_DEFINED_CMDS = "userdefinedcommands";
    public static final String NAME = "name"; 
    public static final String WORKSPACE = "workspace";
    public static final String WORKSPACE_VAR = "workspacevariable";
    public static final String VARIABLE = "variable";
    public static final String VALUE = "value";
    public static final String SAVED_COMMANDS = "savedcommands";
    public static final String STATUS = "status";
    public static final String GREEN = "g";
    public static final String RED = "r";
    public static final String BLUE = "b";
    public static final String PEN = "pen";
    public static final String SET_PEN_SIZE = "setpensize ";
    public static final String PARAMS = "params";

    private Element myRoot;

    /**
     * Gets the root element of the file.
     * @param file
     * @throws ParserConfigurationException
     * @throws FileNotFoundException
     * @throws SAXException
     * @throws IOException
     */
    public SavedWorkspaceXMLReader (File file) throws ParserConfigurationException,
    FileNotFoundException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(file));
        myRoot = document.getDocumentElement();
    }

    /**
     * Retrieves the initial pen parameters from the xml file and creates
     * a list of commands that will create these parameters.
     * @return List of commands
     */
    public WorkspacePenCommands getInitialPenCommands () {
        WorkspacePenCommands penCommands = new WorkspacePenCommands();
        Element penParameters = (Element) myRoot.getElementsByTagName(PEN).item(0);
        if(penParameters != null){
            penCommands.addCommand(SET_FIRST_PALETTE_INDEX + penParameters.getAttribute(RED) + " " +
                    penParameters.getAttribute(GREEN) + " " +
                    penParameters.getAttribute(BLUE));
            penCommands.addCommand(SET_PEN_COLOR);
            penCommands.addCommand(SET_PEN_SIZE + penParameters.getAttribute(PIXELS));
            penCommands.addCommand(PEN + penParameters.getAttribute(STATUS).toLowerCase());
        }
        return penCommands;
    }

    /**
     * Retrieves the parameters for the screen from the xml file.
     * @return
     */
    public WorkspaceScreenParameters getScreenParameters () {
        WorkspaceScreenParameters params = new WorkspaceScreenParameters();
        Element screenParameters = (Element) myRoot.getElementsByTagName(SCREEN).item(0);
        params.put(COLOR, screenParameters.getAttribute(COLOR));
        params.put(TOGGLE_GRID, screenParameters.getAttribute(TOGGLE_GRID));
        return params;
    }

    /**
     * Retrieves a list of workspace variables from the xml file.
     * @return
     */
    public ObservableList<WorkspaceVariable> getWorkspaceVariables () {
        ObservableList<WorkspaceVariable> workspaceVariables = FXCollections.observableArrayList();
        NodeList commands = myRoot.getElementsByTagName(VARIABLE);
        for (int i = 0; i < commands.getLength(); i++) {
            Element var = (Element) commands.item(i);
            workspaceVariables.add(
                                   new WorkspaceVariable(var.getAttribute(NAME),
                                                         Double.parseDouble(var.getAttribute(VALUE))));
        }
        return workspaceVariables;
    }

    /**
     * Retrieves a list of user defined commands from the xml file.
     * @return
     */
    public ObservableList<DisplayedUserCommand> getUserDefinedCommands () {
        ObservableList<DisplayedUserCommand> userDefinedCommands =
                FXCollections.observableArrayList();
        Element headNode = (Element) myRoot.getElementsByTagName(USER_DEFINED_CMDS).item(0);
        NodeList commands = headNode.getElementsByTagName(COMMAND);
        for (int i = 0; i < commands.getLength(); i++) {
            Element el = (Element) commands.item(i);
            userDefinedCommands.add(new DisplayedUserCommand(el.getAttribute(NAME),
                                                             el.getAttribute(PARAMS),
                                                             el.getTextContent()));
        }
        return userDefinedCommands;
    }

    /**
     * Retrieves a list of saved commands from the XML File.
     * @return
     */
    public ObservableList<String> getSavedCommands () {
        return getStringListFromElements(SAVED_COMMANDS);
    }

    /**
     * Helper function to get a list from a node list in an xml file.
     * @param elementName
     * @return
     */
    public ObservableList<String> getStringListFromElements (String elementName) {
        ObservableList<String> userDefinedCommands = FXCollections.observableArrayList();
        Element headNode = (Element) myRoot.getElementsByTagName(elementName).item(0);
        NodeList commands = headNode.getElementsByTagName(COMMAND);
        for (int i = 0; i < commands.getLength(); i++) {
            userDefinedCommands.add(commands.item(i).getTextContent());
        }
        return userDefinedCommands;
    }

    /**
     * A workspace data holder that holds all of the information parsed
     * from the xml file.
     * @return A workspace data holder
     */
    public WorkspaceDataHolder getWorkspaceDataHolder () {
        return new WorkspaceDataHolder(getWorkspaceVariables(),
                                       FXCollections.observableArrayList(),
                                       getUserDefinedCommands(),
                                       getSavedCommands(), FXCollections.observableArrayList(),
                                       FXCollections.observableArrayList());
    }
}
