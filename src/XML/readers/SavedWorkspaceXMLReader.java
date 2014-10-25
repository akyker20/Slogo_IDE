package XML.readers;

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
import XML.workspaceparams.WorkspaceParameters;

public class SavedWorkspaceXMLReader {
    
    public static final String COMMAND = "command";
    public static final String PARAMETERS = "parameters";
    public static final String SCREEN = "screen";
    public static final String COLOR = "color";
    public static final String TOGGLE_GRID = "toggleGrid";
    public static final String TRUE = "true";
    public static final String TYPE = "type";
    public static final String PIXELS = "pixels";
    public static final String USER_DEFINED_CMDS = "userDefinedCommands";
    public static final String NAME = "name";
    
    private File myFile;
    private Element myRoot;
    
    public SavedWorkspaceXMLReader(File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
        myFile = file;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(file));
        myRoot = document.getDocumentElement();
    }

    public WorkspaceParameters getPenParams () {
        WorkspaceParameters params = new WorkspaceParameters();
        Element penParameters = (Element) myRoot.getElementsByTagName(SCREEN).item(0);
        params.put(COLOR, penParameters.getAttribute(COLOR));
        params.put(TYPE, penParameters.getAttribute(TYPE));
        params.put(PIXELS, penParameters.getAttribute(PIXELS));
        return params;
    }

    public WorkspaceParameters getScreenParameters () {
        WorkspaceParameters params = new WorkspaceParameters();
        Element screenParameters = (Element) myRoot.getElementsByTagName(SCREEN).item(0);
        params.put(COLOR, screenParameters.getAttribute(COLOR));
        params.put(TOGGLE_GRID, screenParameters.getAttribute(TOGGLE_GRID));
        return params; 
    }
    
    public ObservableList<String> getUserDefinedCommands(){
        ObservableList<String> userDefinedCommands = FXCollections.observableArrayList();           
        NodeList commands = myRoot.getElementsByTagName(USER_DEFINED_CMDS);
        for(int i = 0; i < commands.getLength(); i++){
            userDefinedCommands.add(commands.item(i).getTextContent());
        } 
        return userDefinedCommands;
    }
}
