package gui.componentdrawers.buttonholder.tabs;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class OptionsTab extends Tab {
    public OptionsTab(Node[] features, String tabName){
        VBox featureContainer = new VBox();
        for(Node feature:features){
            featureContainer.getChildren().add(feature);
        }
        this.setContent(featureContainer);
        this.setText(tabName);
    }
}
