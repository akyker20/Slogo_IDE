package gui.componentdrawers;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import gui.mainclasses.StageInitializer;


public class GridDrawer extends ComponentDrawer {

    public static final double GRID_WIDTH_RATIO = .667;
    public static final double GRID_HEIGHT_RATIO = .6;
    public static final double GRID_WIDTH = StageInitializer.SCREEN_WIDTH * GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = StageInitializer.SCREEN_HEIGHT * GRID_HEIGHT_RATIO;
    public static final int GRID_NUM_ROWS = 10;
    public static final int GRID_NUM_COLS = 10;
    private GridPane myGridPane;
    private Pane myGrid;
    
    public GridDrawer (String name) {
        super(name);
        myGridPane = initializeGridPane();
        this.setPrefWidth(GRID_WIDTH);
        this.setPrefHeight(GRID_HEIGHT + 20);
        this.getChildren().addAll(new Label("SLogo Grid"), myGridPane);
    }
    
    private GridPane initializeGridPane () {
        GridPane pane = new GridPane();
        pane.setHgap(GridDrawer.GRID_WIDTH / GRID_NUM_ROWS);
        pane.setVgap(GridDrawer.GRID_HEIGHT / GRID_NUM_COLS);
        pane.add(new Rectangle(), GRID_NUM_ROWS, GRID_NUM_COLS);
        return pane;
    }

   
    public void toggleGrid () {
        myGridPane.setGridLinesVisible(!myGridPane.isGridLinesVisible());
    }
    
    public void setGrid(Pane grid){
        myGrid = grid;
        drawShape(myGridPane);
        super.drawShape(grid);
    }
    
    @Override
    public void drawShape(Node n){
        myGrid.getChildren().add(n);
    }

    /**
     * Changes the background color of the grid, this method is called from the
     * SetGridColorFeature
     * @param style
     */
    public void changeGridColor (String style) {
        myGrid.setStyle(style);  
    }
}
