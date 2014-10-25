package gui.componentdrawers.optionsholder.tabs;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OptionsTab extends Tab {
    
    public OptionsTab(Node feature, String tabName) {
        this.setContent(feature);
        this.setText(tabName);
        this.setClosable(false);
    }
    
    public OptionsTab(Node[] leftFeatures,Node[] rightFeatures,  String tabName){    
        VBox leftFeatureContainer = new VBox(5);
        VBox rightFeatureContainer = new VBox(5);
        HBox featureContainerHolder = new HBox(2);
        
        featureContainerHolder.getChildren().add(leftFeatureContainer);
        featureContainerHolder.getChildren().add(rightFeatureContainer);
        
        leftFeatureContainer.setPadding(new Insets(5, 0, 5, 5));
        rightFeatureContainer.setPadding(new Insets(5, 0, 5, 5));
        
        for(Node feature:leftFeatures){
            leftFeatureContainer.getChildren().add(feature);
        }
        
        for(Node feature:rightFeatures){
            rightFeatureContainer.getChildren().add(feature);
        }        
        
        this.setContent(featureContainerHolder);
        this.setText(tabName);
        this.setClosable(false);
    }
}
