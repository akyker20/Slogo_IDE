package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.mainclasses.GUIController;
import gui.nonbuttonfeatures.ErrorPopup;
import java.util.Map;
import javafx.scene.Node;

public class ErrorMessageFactory extends ObjectFactory {
    public static final String PARENT = ComponentInitializer.ERROR_POPUP;
    public static final String TYPE = FactoryInitializer.ERROR_MESSAGE_FACTORY;
    public static final String ERROR_MESSAGE = "errorMessage";

    public ErrorMessageFactory (String name) {
        super(name);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        ErrorPopup errorPopup = new ErrorPopup(params.get(ERROR_MESSAGE));
        errorPopup.show(GUIController.GUI_STAGE);
        return null;
    }

}
