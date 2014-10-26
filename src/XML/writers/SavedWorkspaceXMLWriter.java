package XML.writers;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndex;
import gui.variableslist.WorkspaceVariable;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import workspaceState.UserDefinedCommandCollection.Command;
import XML.readers.SavedWorkspaceXMLReader;


/**
 * The purpose of this class is to provide a means for generating driver
 * xml files, and also be able to edit, remove, and add advertisements to
 * the master file.
 * @author Austin Kyker
 *
 */
public class SavedWorkspaceXMLWriter {


    /**
     * Writes the contents of the document to the XML file specified.
     * @param document
     * @param xmlFile
     * @throws TransformerException
     * @throws ParserConfigurationException 
     */
    public static void writeFile(WorkspaceDataHolder dataHolder) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
       
        Element root = document.createElement("workspace");
        document.appendChild(root);
        
        Element savedCommands = document.createElement("savedCommands");
        for(String savedCommand: dataHolder.getMySavedCommandsList()){
            Element command = document.createElement("command");
            command.setTextContent(savedCommand);
            savedCommands.appendChild(command);
        }
        
        Element workspaceVariables = document.createElement("workspacevariables");
        for(WorkspaceVariable workspaceVariable: dataHolder.getMyVariablesList()){
            Element command = document.createElement("command");
            command.setAttribute("name", workspaceVariable.getMyName());
            command.setAttribute("value", ""+workspaceVariable.getMyValue());
            workspaceVariables.appendChild(command);
        }
        
        Element colorIndices = document.createElement("colorindices");
        for(ColorIndex colorIndex: dataHolder.getMyColorIndexList()){
            Element el = document.createElement("colorindex");
            el.setAttribute("index", ""+colorIndex.getMyIndex());
            el.setAttribute("color", ""+colorIndex.getMyColor().toString());
            colorIndices.appendChild(el);
        }
        
        Element userDefinedCommands = document.createElement("userdefinedcommands");
        for(DisplayedUserCommand userDefinedCommand:dataHolder.getMyUserDefinedCommandList()){
            Element el = document.createElement("command");
            el.setAttribute("name", userDefinedCommand.getMyName());
            el.setAttribute("params", userDefinedCommand.getMyParams());
            el.setTextContent(userDefinedCommand.getMyContent());
            userDefinedCommands.appendChild(el);   
        }
        
        
        root.appendChild(savedCommands);
        root.appendChild(workspaceVariables);
        root.appendChild(colorIndices);
        root.appendChild(userDefinedCommands);
         
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        StreamResult result = new StreamResult(new File("./workspaceFiles/savedWorkspace.xml"));
        transformer.transform(new DOMSource(document), result);
        System.out.println("File saved!");
    }
}