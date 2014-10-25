package gui.componentdrawers.optionsholder;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.optionsholder.tabs.OptionsTab;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class OptionsHolderDrawer extends ComponentDrawer {
    private TabPane myButtonHolder;

    public OptionsHolderDrawer (String name) {
        super(name);
        myButtonHolder = new TabPane();
        myButtonHolder.setId("tabPane");
        myButtonHolder.setPrefWidth(245);
        myButtonHolder.setLayoutY(20);
        super.drawShape(new Node[]{ new Label("Options"), myButtonHolder});
    }

    /**
     * Adds the options tabs to the tab pane. This method is called in feature intializer
     * after the tabs are initialized with their corresponding features.
     * @param optionsTabs
     */
    public void addTabs (Tab[] optionsTabs) {
        myButtonHolder.getTabs().addAll(optionsTabs);
    }
}
