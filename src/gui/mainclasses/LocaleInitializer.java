package gui.mainclasses;
import gui.resources.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleInitializer {
    public static ResourceBundle init() {
        Locale[] supportedLocales = {
          Locale.ENGLISH,   
          Locale.FRENCH
        };
        ResourceBundle guiText = ResourceBundle.getBundle("gui.resources/LabelsBundle",supportedLocales[0]);
        return guiText;
    }
}
