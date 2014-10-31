package gui.mainclasses;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

//This entire file is part of my masterpiece.
//Allan Kiplagat

/**
 * Singleton class generates the text to be displayed on the GUI using resource bundles
 * @author allankiplagat
 *
 */
public class TextGenerator  {

    public static final String SLOGO = "slogo";

    public static final String FILE = "file";
    public static final String LOAD_WORKSPACE = "loadWorkspace";
    public static final String SAVE_WORKSPACE = "saveWorkspace";
    public static final String NEW_WORKSPACE = "newWorkspace";
    public static final String SELECT_XMLFILE = "selectXMLFile";

    public static final String EDIT = "edit";
    public static final String PREFERENCES = "preferences";

    public static final String HELP = "help";
    public static final String GETTING_STARTED = "gettingStarted";
    public static final String BASIC_COMMANDS = "basicCommands";
    public static final String COMPLEX_COMMANDS = "complexCommands";

    public static final String WORKSPACE_LABEL = "workspace";

    public static final String TURTLE_SCREEN = "turtleScreen";
    public static final String PREVIOUS_COMMANDS = "previousCommands";
    public static final String COMMAND_LINE = "commandLine";

    public static final String ERRORS = "errors";

    public static final String WORKSPACE_VARIABLES = "workspaceVariables";
    public static final String VARIABLE = "variable";
    public static final String VALUE = "value";

    public static final String COMMANDS = "commands";
    public static final String SAVED = "saved";
    public static final String USER_DEFINED = "userDefined";
    public static final String NAME = "name";
    public static final String PARAMETERS = "parameters";

    public static final String OPTIONS = "options";
    public static final String GENERAL = "general";
    public static final String PEN = "pen";
    public static final String COLORS = "colors";
    public static final String IMAGES = "images";
    public static final String TOGGLE_GRID = "toggleGrid";
    public static final String SAVE_COMMAND = "saveCommand";
    public static final String CLEAR_WORKSPACE = "clearWorkspace";
    public static final String IMAGE_DROP_AREA = "imageDropArea";
    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String INDEX = "index";
    public static final String COLOR = "color";
    public static final String IMAGE = "image";

    public static final String CHINESE = "Chinese";
    public static final String ENGLISH = "English";
    public static final String FRENCH = "French";
    public static final String ITALIAN = "Italian";

    private static TextGenerator myself;
    private Map<String, Locale> supportedLocales;
    private ResourceBundle myCurrentResourceBundle;

    private TextGenerator() {
        supportedLocales = new HashMap<String, Locale>();
        addSupportedLanguages();
        myCurrentResourceBundle = getResourceBundle(ENGLISH);
    }

    public static TextGenerator getInstance() {
        if (myself==null) {
            myself = new TextGenerator();
        } 
        return myself;
    }

    private void addLocale(String language,Locale locale) {
        supportedLocales.put(language, locale);
    }

    //in the future have this read from properties file too
    private void addSupportedLanguages() {
        addLocale(CHINESE, Locale.CHINESE);
        addLocale(ENGLISH, Locale.ENGLISH);
        addLocale(FRENCH, Locale.FRENCH);
        addLocale(ITALIAN, Locale.ITALIAN);
    }

    private ResourceBundle getResourceBundle (String language) {
        return ResourceBundle.getBundle("resources.guiResources/LabelsBundle",
                                        supportedLocales.get(language));
    }

    /**
     * Method gets text in the current language
     * @param text
     * @return translated text
     */
    public String get(String text) {
        return myCurrentResourceBundle.getString(text);
    }

    /**
     * Method sets the current TextGenerator language
     * @param language
     * @return true if language switch successful, false otherwise
     */
    public boolean setLanguage (String language) {
        if (supportedLocales.containsKey(language)) {
            myCurrentResourceBundle = getResourceBundle(language); 
            return true;
        }
        return false;
    }

    public boolean languageSupported(String language) {
        return supportedLocales.containsKey(language);
    }
}
