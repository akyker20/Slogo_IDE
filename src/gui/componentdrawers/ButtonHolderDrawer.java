package gui.componentdrawers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class ButtonHolderDrawer extends ComponentDrawer {
    private Pane myButtonHolder;

    public ButtonHolderDrawer (String name) {
        super(name);
        myButtonHolder = new VBox(10);
        myButtonHolder.setId("buttonHolder");
        myButtonHolder.setPrefWidth(245);
        myButtonHolder.setLayoutY(20);
        myButtonHolder.setPadding(new Insets(10));
        this.getChildren().addAll(new Label("User Options"), myButtonHolder);
    }
    
    /**
     * Draw to the button holder pane rather than the entire pane.
     */
    @Override
    public void drawShape(Node n){
        myButtonHolder.getChildren().add(n);
    }
}
