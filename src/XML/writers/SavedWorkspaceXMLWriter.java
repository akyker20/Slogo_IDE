package XML.writers;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.mainclasses.workspace.WorkspaceDataHolder;
import gui.nonbuttonfeatures.tableviews.colorindex.ColorIndex;
import gui.variableslist.WorkspaceVariable;
import java.io.File;
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
import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceScreenParameters;


/**
 * The purpose of this class is to provide a means for generating driver
 * xml files, and also be able to edit, remove, and add advertisements to
 * the master file.
 *
 * @author Austin Kyker
 *
 */
public class SavedWorkspaceXMLWriter {
    
    private static final String PARAMETERS = "parameters";

    /**
     * Writes the contents of the document to the XML file specified.
     *
     * @param document
     * @param xmlFile
     * @throws TransformerException
     * @throws ParserConfigurationException
     */
    public static void writeFile (WorkspaceDataHolder dataHolder, 
                                  WorkspaceScreenParameters screenParams) throws TransformerException,
    ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement(SavedWorkspaceXMLReader.WORKSPACE);
        document.appendChild(root);
        
        Element parameters = document.createElement(PARAMETERS);
        Element screen = document.createElement(SavedWorkspaceXMLReader.SCREEN);
        parameters.appendChild(screen);
        screen.setAttribute(SavedWorkspaceXMLReader.TOGGLE_GRID, 
                            screenParams.extractParams(SavedWorkspaceXMLReader.TOGGLE_GRID));
        screen.setAttribute(SavedWorkspaceXMLReader.COLOR, 
                            screenParams.extractParams(SavedWorkspaceXMLReader.COLOR));
        
        

        Element savedCommands = document.createElement(SavedWorkspaceXMLReader.SAVED_COMMANDS);
        for (String savedCommand : dataHolder.getMySavedCommandsList()) {
            Element command = document.createElement(SavedWorkspaceXMLReader.COMMAND);
            command.setTextContent(savedCommand);
            savedCommands.appendChild(command);
        }

        Element workspaceVariables = document.createElement(SavedWorkspaceXMLReader.WORKSPACE);
        for (WorkspaceVariable workspaceVariable : dataHolder.getMyVariablesList()) {
            Element command = document.createElement(SavedWorkspaceXMLReader.COMMAND);
            command.setAttribute(SavedWorkspaceXMLReader.NAME, workspaceVariable.getMyName());
            command.setAttribute(SavedWorkspaceXMLReader.VALUE, "" + workspaceVariable.getMyValue());
            workspaceVariables.appendChild(command);
        }

        Element userDefinedCommands = document.createElement(SavedWorkspaceXMLReader.USER_DEFINED_CMDS);
        for (DisplayedUserCommand userDefinedCommand : dataHolder.getMyUserDefinedCommandList()) {
            Element el = document.createElement(SavedWorkspaceXMLReader.COMMAND);
            el.setAttribute(SavedWorkspaceXMLReader.NAME, userDefinedCommand.getMyName());
            el.setAttribute(SavedWorkspaceXMLReader.PARAMS, userDefinedCommand.getMyParams());
            el.setTextContent(userDefinedCommand.getMyContent());
            userDefinedCommands.appendChild(el);
        }

        root.appendChild(parameters);
        root.appendChild(savedCommands);
        root.appendChild(workspaceVariables);
        root.appendChild(userDefinedCommands);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new File("./workspaceFiles/savedWorkspace.xml"));
        transformer.transform(new DOMSource(document), result);
        System.out.println("File saved!");
    }
}
