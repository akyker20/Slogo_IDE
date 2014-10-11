package gui.factories;

import gui.componentdrawers.ComponentInitializer;
import gui.variableslist.WorkspaceVariablesFeature;
import java.util.Map;
import javafx.scene.Node;

public class RefreshVariablesViewFactory extends ObjectFactory {
    public static final String PARENT = ComponentInitializer.STAGE_DRAWER;
    public static final String TYPE = FactoryInitializer.REFRESH_VARIABLES_VIEW_FACTORY;
    
    public RefreshVariablesViewFactory (String name) {
        super(name);
    }

    @Override
    public Node generateObject (Map<String, String> params) {
        WorkspaceVariablesFeature.resetObservableList();
        return new NullNode();
    }
}
