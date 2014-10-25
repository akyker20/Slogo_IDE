package gui.componentdrawers;

import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceParameters;
import gui.factories.turtlefactory.TurtleNodes;
import gui.mainclasses.StageInitializer;
import gui.nonbuttonfeatures.TurtleScreenFeature;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class TurtleScreenDrawer extends ComponentDrawer {

    public static final double GRID_WIDTH_RATIO = .6;
    public static final double GRID_HEIGHT_RATIO = .5;
    public static final double GRID_WIDTH = StageInitializer.SCREEN_WIDTH * GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = StageInitializer.SCREEN_HEIGHT * GRID_HEIGHT_RATIO;
    public static final int GRID_NUM_ROWS = 10;
    public static final int GRID_NUM_COLS = 10;

    //This is just for the grid lines
    private TurtleScreenFeature myTurtleScreen;
    
    private TurtleNodes myTurtleNodes;

    //This is the actual grid to which nodes will be drawn.
    private Pane myGrid;

    public TurtleScreenDrawer (String name, TurtleNodes turtleNodes) {
        super(name);
        myGrid = initializeGridPane();
        myTurtleNodes = turtleNodes;
        this.setPrefWidth(GRID_WIDTH);
        this.setPrefHeight(GRID_HEIGHT + 20);
        this.getChildren().addAll(new Label("SLogo Grid"));  
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
        line.getStyleClass().add("line");
        line.setStartX(col*GRID_WIDTH/GRID_NUM_COLS);
        line.setStartY(0);
        line.setEndX(col*GRID_WIDTH/GRID_NUM_COLS);
        line.setEndY(GRID_HEIGHT);
        return line;
    }


    private Line makeRowLine (int row) {
        Line line = new Line();
        line.getStyleClass().add("line");
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
        if(!myTurtleScreen.getChildren().contains(myGrid)){
            myTurtleScreen.getChildren().add(0, myGrid);
        }
        else{
            myTurtleScreen.getChildren().remove(myGrid);
        }
    }

    /**
     * Adds the grid to the GridDrawer pane. Adds the GridPane used for drawing
     * relative grid lines to the grid.
     * @param grid
     */
    public void setTurtleScreenFeature(TurtleScreenFeature grid){
        myTurtleScreen = grid;
        super.drawShape(new Node[]{myTurtleScreen});
    }

    /**
     * Overrides the super drawShapeMethod - Instead of drawing shapes on the
     * GridDrawer pane (which would have been the default), shapes will be drawn
     * on the grid.
     */
    @Override
    public void drawShape(Node[] n){
        for (int k=0;k<n.length;k++) {
            if (!myTurtleScreen.getChildren().contains(n[k]))
                myTurtleScreen.getChildren().add(n[k]);
        } 
    }

    /**
     * Changes the background color of the grid, this method is called from the
     * SetGridColorFeature
     * @param style
     */
    public void changeScreenColor (String style) {
        myTurtleScreen.setStyle(style);  
    }


    public void resetScreen () {
        myTurtleNodes.clearTurtleNodes();
        myTurtleScreen.getChildren().clear();
    }    
}

