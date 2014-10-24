package gui.componentdrawers;

import gui.mainclasses.StageInitializer;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ErrorDrawer extends ComponentDrawer {

    private ListView<Label> myListView;

    public ErrorDrawer (String name) {
        super(name);
        this.getStyleClass().add("errorDrawer");
        this.setWidth(StageInitializer.SCREEN_WIDTH * TurtleScreenDrawer.GRID_WIDTH_RATIO);
        super.drawShape(new Label[]{new Label("Errors")});
    }

    public void setParentNode(ListView view){
        myListView = view;
        this.getChildren().add(myListView);
    }


    @Override
    public void drawShape(Node[] n){
        Label label = (Label) n[0];
        label.setStyle("-fx-color: red");
        myListView.getItems().clear();
        myListView.getItems().add(label);
    }

}
