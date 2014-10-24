package gui.componentdrawers.buttonholder;

import gui.componentdrawers.ComponentDrawer;
import gui.componentdrawers.buttonholder.tabs.OptionsTab;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class ButtonHolderDrawer extends ComponentDrawer {
    private TabPane myButtonHolder;

    public ButtonHolderDrawer (String name) {
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
    public void addTabs (OptionsTab[] optionsTabs) {
        myButtonHolder.getTabs().addAll(optionsTabs);
    }
}
