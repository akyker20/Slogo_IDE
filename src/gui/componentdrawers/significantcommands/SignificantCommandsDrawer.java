package gui.componentdrawers.significantcommands;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import gui.componentdrawers.ComponentDrawer;

public class SignificantCommandsDrawer extends ComponentDrawer {
    
    private TabPane mySignificantCommandsPane;

    public SignificantCommandsDrawer (String name) {
        super(name);
        mySignificantCommandsPane = new TabPane();
        mySignificantCommandsPane.setId("tabPane");
        mySignificantCommandsPane.setPrefWidth(245);
        mySignificantCommandsPane.setLayoutY(20);
        super.drawShape(new Node[]{ new Label("Commands"), mySignificantCommandsPane});
    }

    public void addTabs (Tab[] tabs) {
        mySignificantCommandsPane.getTabs().addAll(tabs);   
    }

}
