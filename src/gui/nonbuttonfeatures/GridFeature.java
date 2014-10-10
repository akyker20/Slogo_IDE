package gui.nonbuttonfeatures;
import gui.componentdrawers.GridDrawer;
import javafx.scene.layout.Pane;
/**
 * This is the grid. The reason it is a feature is that we may make
 * it interactive in the future - for instance click to draw another
 * turtle
 * @author Austin Kyker
 *
 */
public class GridFeature extends Pane {
    public GridFeature(GridDrawer parentDrawer){
        this.setPrefWidth(GridDrawer.GRID_WIDTH);
        this.setPrefHeight(GridDrawer.GRID_HEIGHT);
        this.getStyleClass().add("grid");
        this.setLayoutY(20);
        parentDrawer.setGrid(this);
    }
}
