package gui.mainclasses;

import java.util.Locale;
import java.util.ResourceBundle;


public class LocaleInitializer {
    public static ResourceBundle init () {
        Locale[] supportedLocales = {
                                     Locale.ENGLISH,
                                     Locale.FRENCH
        };
        ResourceBundle guiText =
                ResourceBundle.getBundle("resources.guiResources/LabelsBundle", supportedLocales[0]);
        return guiText;
    }
}
