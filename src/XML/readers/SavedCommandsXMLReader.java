package XML.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * XMLParser that uses the SAX library to parse the master file and
 * create video instances that will later be displayed to the user
 * on the front end in a TableView.
 * @author Austin Kyker
 *
 */
public class SavedCommandsXMLReader {

    private static final String COMMAND = "command";


    /**
     * @return a list of the saved commands
     * @throws IOException 
     * @throws SAXException 
     * @throws FileNotFoundException 
     * @throws ParserConfigurationException 
     */
    public  static List<String> getSavedCommands(File file) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(file));
        List<String> commands = new ArrayList<String>();
        Element root = document.getDocumentElement();
        NodeList commandNodes = root.getElementsByTagName(COMMAND);
        for(int i = 0; i < commandNodes.getLength(); i++){
            Element commandNode = (Element) commandNodes.item(i);
            commands.add(commandNode.getAttribute("value"));
        }
        return commands;
    }
}



