package XML;

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


/**
 * The purpose of this class is to provide a means for generating driver
 * xml files, and also be able to edit, remove, and add advertisements to
 * the master file.
 * @author Austin Kyker
 *
 */
public class SavedCommandsXMLWriter {


    /**
     * Writes the contents of the document to the XML file specified.
     * @param document
     * @param xmlFile
     * @throws TransformerException
     * @throws ParserConfigurationException 
     */
    public static void writeFile(List<String> commands) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element commandsNode = document.createElement("commands");
        for(String command: commands){
            Element commandNode = document.createElement("command");
            commandNode.setAttribute("value", command);
            commandsNode.appendChild(commandNode);
        }
        document.appendChild(commandsNode);
         
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        StreamResult result = new StreamResult(new File("./savedcommands/savedcommands.xml"));
        transformer.transform(new DOMSource(document), result);
        System.out.println("File saved!");
    }
}