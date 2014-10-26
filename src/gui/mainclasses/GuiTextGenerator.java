package gui.mainclasses;

import java.util.Locale;
import java.util.ResourceBundle;

public class GuiTextGenerator {
    private static ResourceBundle myLanguagesBundle = init();
    
    public static final String SLOGO_TITLE_TEXT = "slogo";
    
    public static final String CLEAR_WORKSPACE_TEXT = "clearWorkspace";
    public static final String SAVE_COMMAND_TEXT = "saveCommand";
    public static final String TOGGLE_GRID_TEXT = "toggleGrid";
    
    public static final String FILE_TEXT = "file";
    public static final String LOAD_WORKSPACE_TEXT = "loadWorkspace";
    public static final String NEW_WORKSPACE_TEXT = "newWorkspace";
    public static final String SELECT_XMLFILE_TEXT = "selectXMLFile";
    
    public static final String EDIT_MENU_TEXT = "edit";
    public static final String PREFERENCES_TEXT = "preferences";
    
    public static final String HELP_TEXT = "help";
    public static final String GETTING_STARTED_TEXT = "gettingStarted";
    public static final String BASIC_COMMANDS_TEXT = "basicCommands";
    public static final String COMPLEX_COMMANDS_TEXT = "complexCommands";
    
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
    
}
