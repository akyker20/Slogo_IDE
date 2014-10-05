package XML;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import drawableobject.DrawableObject;


public class XMLParser extends DefaultHandler {
    Stage stage;
    private FileChooser chooser = new FileChooser();
    SAXParserFactory docFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = docFactory.newSAXParser();

    Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();

    String parent;
    String type;
    String name;
    Map<String, String> rawParameters = new HashMap<>();

    public XMLParser (Stage aStage) throws Exception {
        stage = aStage;
        configureFileChooser(chooser);
        parseFile();
    }

    private static void configureFileChooser (FileChooser fileChooser) {
        fileChooser.setTitle("Open XML File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") +
                                                 System.getProperty("file.separator") + "src" +
                                                 System.getProperty("file.separator") + "xml"));
        fileChooser.getExtensionFilters()
                .addAll(
                        new FileChooser.ExtensionFilter("All Files", "*.*"),
                        new FileChooser.ExtensionFilter("XML", "*.xml"));
    }

    private void parseFile () throws SAXException, IOException {
        File xmlFile = chooser.showOpenDialog(stage);
        try {
            saxParser.parse(xmlFile, this);
        }
        catch (Exception e) {
            // create multiple catches for different types of exceptions and implementations of what
            // to do then
        }
    }

    @Override
    public void startElement (String uri,
                              String localName,
                              String elementName,
                              Attributes attributes) throws SAXException {
        if (elementName.equalsIgnoreCase("drawableObject")) {
            if (rawParameters.size() > 0) {
                objectQueue.add(new DrawableObject(parent, type, name, rawParameters));
            }
            parent = attributes.getValue("parent");
            type = attributes.getValue("type");
            name = attributes.getValue("name");
            rawParameters.clear();
        }
        if (elementName.equalsIgnoreCase("parameter")) {
            rawParameters.put(attributes.getValue("name"), attributes.getValue("value"));
        }
    }

}
