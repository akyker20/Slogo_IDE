package gui.componentdrawers.optionsholder;

import gui.componentdrawers.ComponentDrawer;
import gui.mainclasses.TextGenerator;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Class hosts a TabPane in which tabs (General,Pen,Colors and Images) are displayed
 * @author akyker20, allankiplagat
 *
 */
public class OptionsHolderDrawer extends ComponentDrawer {
    private TabPane myButtonHolder;

    public OptionsHolderDrawer (String name) {
        super(name);
        myButtonHolder = new TabPane();
        myButtonHolder.setId(ComponentDrawer.TABPANE_LABEL);
        myButtonHolder.setPrefWidth(245);
        myButtonHolder.setLayoutY(20);
        super.drawShape(new Node[] { new Label(textGen.get(TextGenerator.OPTIONS)),
                                     myButtonHolder });
    }

    /**
     * Adds the options tabs to the tab pane. This method is called in feature initializer
     * after the tabs are initialized with their corresponding features.
     *
     * @param optionsTabs
     */
    public void addTabs (Tab[] optionsTabs) {
        myButtonHolder.getTabs().addAll(optionsTabs);
    }
}
