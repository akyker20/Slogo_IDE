package gui.componentdrawers.significantcommands;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import gui.componentdrawers.ComponentDrawer;
import gui.mainclasses.TextGenerator;

/**
 * A component drawer that holds both the saved commands tab
 * and the user defined functions tab.
 * @author akyker20
 *
 */
public class SignificantCommandsDrawer extends ComponentDrawer {
    
    private TabPane mySignificantCommandsPane;

    public SignificantCommandsDrawer (String name) {
        super(name);
        mySignificantCommandsPane = new TabPane();
        mySignificantCommandsPane.setId("tabPane");
        mySignificantCommandsPane.setPrefWidth(245);
        mySignificantCommandsPane.setLayoutY(20);
        super.drawShape(new Node[]{ new Label(TextGenerator.get(TextGenerator.COMMANDS)), 
                                    mySignificantCommandsPane});
    }

    /**
     * A method to add the tabs to the tabpane.
     * @param tabs
     */
    public void addTabs (Tab[] tabs) {
        mySignificantCommandsPane.getTabs().addAll(tabs);   
    }

}
