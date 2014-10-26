package gui.componentdrawers.optionsholder.tabs;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * A super class that represents a tab. The subclasses of this tab will be represented
 * in the options tabpane in the bottom right of the screen.
 *
 * @author akyker20
 *
 */
public class OptionsTab extends Tab {

    /**
     * Default constructor will draw its features in the centers.
     *
     * @param feature
     * @param tabName
     */
    public OptionsTab (Node feature, String tabName) {
        setContent(feature);
        setText(tabName);
        setClosable(false);
    }

    /**
     * More complex tab that will have features displayed on the left side
     * and on the right side. An example of this tab is the General Options Tab
     * in the options component drawer.
     *
     * @param leftFeatures
     * @param rightFeatures
     * @param tabName
     */
    public OptionsTab (Node[] leftFeatures, Node[] rightFeatures, String tabName) {
        VBox leftFeatureContainer = new VBox(5);
        VBox rightFeatureContainer = new VBox(5);
        HBox featureContainerHolder = new HBox(2);

        featureContainerHolder.getChildren().add(leftFeatureContainer);
        featureContainerHolder.getChildren().add(rightFeatureContainer);

        leftFeatureContainer.setPadding(new Insets(5, 0, 5, 5));
        rightFeatureContainer.setPadding(new Insets(5, 0, 5, 5));

        for (Node feature : leftFeatures) {
            leftFeatureContainer.getChildren().add(feature);
        }

        for (Node feature : rightFeatures) {
            rightFeatureContainer.getChildren().add(feature);
        }

        setContent(featureContainerHolder);
        setText(tabName);
        setClosable(false);
    }
}
