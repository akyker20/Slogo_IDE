package gui.mainclasses;

import java.util.Locale;
import java.util.ResourceBundle;

public class TextGenerator {
    private static ResourceBundle myLanguagesBundle = init();
    
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
    
    private static ResourceBundle init () {
        Locale[] supportedLocales = {
                                     Locale.ENGLISH,
                                     Locale.FRENCH
        };
        ResourceBundle guiText = ResourceBundle.getBundle("resources.guiResources/LabelsBundle", supportedLocales[0]);
        return guiText;
    }

    public static String get(String text) {
        return myLanguagesBundle.getString(text);
    }
    
    public static setLanguage(String language) {
        
    }
}
