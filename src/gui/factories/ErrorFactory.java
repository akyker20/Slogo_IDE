package gui.factories;

import gui.componentdrawers.ComponentBuilder;
import gui.mainclasses.FactoryBuilder;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Class manages addition of errors to the error display 
 * @author akyker20, allankiplagat
 *
 */
public class ErrorFactory extends ObjectFactory {
    public static final String PARENT = ComponentBuilder.ERROR_DRAWER;
    public static final String TYPE = FactoryBuilder.ERROR_FACTORY;
    public static final String ERROR_MESSAGE = "errorMessage";

    public ErrorFactory (String name) {
        super(name);
    }

    @Override
    public Node[] generateObject (Map<String, String> params) {
        Label label = new Label(params.get(ERROR_MESSAGE));
        return new Label[] { label };
    }
}
