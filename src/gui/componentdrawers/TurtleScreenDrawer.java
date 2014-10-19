package gui.componentdrawers;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import gui.mainclasses.StageInitializer;
import gui.nonbuttonfeatures.TurtleScreenFeature;


public class TurtleScreenDrawer extends ComponentDrawer {

    public static final double GRID_WIDTH_RATIO = .6;
    public static final double GRID_HEIGHT_RATIO = .5;
    public static final double GRID_WIDTH = StageInitializer.SCREEN_WIDTH * GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = StageInitializer.SCREEN_HEIGHT * GRID_HEIGHT_RATIO;
    public static final int GRID_NUM_ROWS = 10;
    public static final int GRID_NUM_COLS = 10;
    
    
    //This is just for the grid lines
    private TurtleScreenFeature myTurtleScreenFeature;
    
    //This is the actual grid to which nodes will be drawn.
    private Pane myGrid;
    
    public TurtleScreenDrawer (String name) {
        super(name);
        myGrid = initializeGridPane();
        this.setPrefWidth(GRID_WIDTH);
        this.setPrefHeight(GRID_HEIGHT + 20);
        this.getChildren().addAll(new Label("SLogo Grid"), myGrid);
    }
    
    
    /**
     * Creates the gridpane whose sole purpose is to aid the ToggleRelativeGridFeature
     * @return
     */
    private Pane initializeGridPane () {
        Pane grid = new Pane();
        for(int row = 1; row < GRID_NUM_ROWS; row++){
            grid.getChildren().add(makeRowLine(row));
        }
        for(int col = 1; col < GRID_NUM_COLS; col++){
            grid.getChildren().add(makeColLine(col));
        }
        return grid;
    }
    
   private Line makeColLine (int col) {
       Line line = new Line();
       line.setStartX(col*GRID_WIDTH/GRID_NUM_COLS);
       line.setStartY(0);
       line.setEndX(col*GRID_WIDTH/GRID_NUM_COLS);
       line.setEndY(GRID_HEIGHT);
       return line;
    }


private Line makeRowLine (int row) {
       Line line = new Line();
       line.setStartX(0);
       line.setStartY(row*GRID_HEIGHT/GRID_NUM_ROWS);
       line.setEndX(GRID_WIDTH);
       line.setEndY(row*GRID_HEIGHT/GRID_NUM_ROWS);
       return line;
    }


/**
    * If the grid lines are already visible, they are removed. Otherwise,
    * the grid lines are displayed.
    */
    public void toggleGrid () {
        myTurtleScreenFeature.getChildren().add(myGrid);
    }
    
    /**
     * Adds the grid to the GridDrawer pane. Adds the GridPane used for drawing
     * relative grid lines to the grid.
     * @param grid
     */
    public void setGrid(TurtleScreenFeature grid){
        myTurtleScreenFeature = grid;
        drawShape(myGrid);
        super.drawShape(myTurtleScreenFeature);
    }
    
    /**
     * Overrides the super drawShapeMethod - Instead of drawing shapes on the
     * GridDrawer pane (which would have been the default), shapes will be drawn
     * on the grid.
     */
    @Override
    public void drawShape(Node n){
        if(!myTurtleScreenFeature.getChildren().contains(n))
            myTurtleScreenFeature.getChildren().add(n);
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
