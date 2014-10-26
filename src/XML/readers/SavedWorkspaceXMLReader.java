package XML.readers;

import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.variableslist.WorkspaceVariable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class SavedWorkspaceXMLReader {
    
    public static final String COMMAND = "command";
    public static final String PARAMETERS = "parameters";
    public static final String SCREEN = "screen";
    public static final String COLOR = "color";
    public static final String TOGGLE_GRID = "toggleGrid";
    public static final String TRUE = "true";
    public static final String PIXELS = "pixels";
    public static final String USER_DEFINED_CMDS = "userDefinedCommands";
    public static final String NAME = "name";
    private static final String VARIABLE = "variable";
    private static final String VALUE = "value";
    private static final String SAVED_COMMANDS = "savedCommands";
    private static final String STATUS = "status";
    private static final String GREEN = "g";
    private static final String RED = "r";
    private static final String BLUE = "b";
    private static final String PEN = "pen";
    
    private Element myRoot;
    
    public SavedWorkspaceXMLReader(File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(file));
        myRoot = document.getDocumentElement();
    }

    public WorkspacePenCommands getInitialPenCommands () {
        WorkspacePenCommands penCommands = new WorkspacePenCommands();
        Element penParameters = (Element) myRoot.getElementsByTagName(PEN).item(0);
        penCommands.addCommand("setpalette 0 "  +  penParameters.getAttribute(RED) + " " + 
                                            penParameters.getAttribute(GREEN) + " " + 
                                            penParameters.getAttribute(BLUE));
        penCommands.addCommand("setpencolor 0");
        penCommands.addCommand("setpensize " + penParameters.getAttribute(PIXELS));
        penCommands.addCommand("pen" + penParameters.getAttribute(STATUS).toLowerCase());
        return penCommands;
    }

    public WorkspaceScreenParameters getScreenParameters () {
        WorkspaceScreenParameters params = new WorkspaceScreenParameters();
        Element screenParameters = (Element) myRoot.getElementsByTagName(SCREEN).item(0);
        params.put(COLOR, screenParameters.getAttribute(COLOR));
        params.put(TOGGLE_GRID, screenParameters.getAttribute(TOGGLE_GRID));
        return params; 
    }
      
    public ObservableList<WorkspaceVariable> getWorkspaceVariables(){
        ObservableList<WorkspaceVariable> workspaceVariables = FXCollections.observableArrayList();           
        NodeList commands = myRoot.getElementsByTagName(VARIABLE);
        for(int i = 0; i < commands.getLength(); i++){
            Element var = (Element) commands.item(i);
            workspaceVariables.add(
                                   new WorkspaceVariable(var.getAttribute(NAME), 
                                                         Double.parseDouble(var.getAttribute(VALUE))));
        } 
        return workspaceVariables;
    }
    
    public ObservableList<String> getUserDefinedCommands(){
        return getStringListFromElements(USER_DEFINED_CMDS);
    }
    
    public ObservableList<String> getSavedCommands () {
        return getStringListFromElements(SAVED_COMMANDS);
    }
    
    public ObservableList<String> getStringListFromElements(String elementName){
        ObservableList<String> userDefinedCommands = FXCollections.observableArrayList();           
        Element headNode = (Element) myRoot.getElementsByTagName(elementName).item(0);
        NodeList commands = headNode.getElementsByTagName(COMMAND);
        for(int i = 0; i < commands.getLength(); i++){
            userDefinedCommands.add(commands.item(i).getTextContent());
        } 
        return userDefinedCommands;
    }

    public WorkspaceDataHolder getWorkspaceDataHolder () {
        return new WorkspaceDataHolder(getWorkspaceVariables(), FXCollections.observableArrayList(), getUserDefinedCommands(), 
                                       getSavedCommands(), FXCollections.observableArrayList());
    }
}
