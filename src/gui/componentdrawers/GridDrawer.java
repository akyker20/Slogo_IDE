package gui.componentdrawers;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import gui.mainclasses.StageInitializer;


public class GridDrawer extends ComponentDrawer {

    public static final double GRID_WIDTH_RATIO = .6;
    public static final double GRID_HEIGHT_RATIO = .6;
    public static final double GRID_WIDTH = StageInitializer.SCREEN_WIDTH * GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = StageInitializer.SCREEN_HEIGHT * GRID_HEIGHT_RATIO;
    public static final int GRID_NUM_ROWS = 10;
    public static final int GRID_NUM_COLS = 10;
    
    
    //This is just for the grid lines
    private GridPane myGridPane;
    
    //This is the actual grid to which nodes will be drawn.
    private static Pane myGrid;
    
    public GridDrawer (String name) {
        super(name);
        myGridPane = initializeGridPane();
        myGrid = new GridFeature();
        this.setPrefWidth(GRID_WIDTH);
        this.setPrefHeight(GRID_HEIGHT + 20);
        this.getChildren().addAll(new Label("SLogo Grid"), myGridPane);
    }
    
    
    /**
     * Creates the gridpane whose sole purpose is to aid the ToggleRelativeGridFeature
     * @return
     */
    private GridPane initializeGridPane () {
        GridPane pane = new GridPane();
        pane.setHgap(GridDrawer.GRID_WIDTH / GRID_NUM_ROWS);
        pane.setVgap(GridDrawer.GRID_HEIGHT / GRID_NUM_COLS);
        pane.add(new Rectangle(), GRID_NUM_ROWS, GRID_NUM_COLS);
        return pane;
    }

    public void resetGrid() {
        myGrid = this.new GridFeature();
    }
    
   /**
    * If the grid lines are already visible, they are removed. Otherwise,
    * the grid lines are displayed.
    */
    public void toggleGrid () {
        myGridPane.setGridLinesVisible(!myGridPane.isGridLinesVisible());
    }
    
    /**
     * Adds the grid to the GridDrawer pane. Adds the GridPane used for drawing
     * relative grid lines to the grid.
     * @param grid
     */
    public void setGrid(Pane grid){
        myGrid = grid;
        drawShape(myGridPane);
        super.drawShape(grid);
    }
    
    /**
     * Overrides the super drawShapeMethod - Instead of drawing shapes on the
     * GridDrawer pane (which would have been the default), shapes will be drawn
     * on the grid.
     */
    @Override
    public void drawShape(Node n){
        if(!myGrid.getChildren().contains(n))
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
    
    /**
     * This is the grid. The reason it is a feature is that we may make
     * it interactive in the future - for instance click to draw another
     * turtle
     * @author Austin Kyker
     *
     */
    public class GridFeature extends Pane {
        public GridFeature(){
            this.setPrefWidth(GRID_WIDTH);
            this.setPrefHeight(GRID_HEIGHT);
            this.getStyleClass().add("grid");
            this.setLayoutY(20);
            setGrid(this);
        }
    } 
    
}
