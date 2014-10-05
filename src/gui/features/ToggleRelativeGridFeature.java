package gui.features;

import gui.componentdrawers.ButtonHolderDrawer;
import gui.componentdrawers.GridDrawer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class ToggleRelativeGridFeature extends Button implements Feature {
    
    public static final int GRID_NUM_ROWS = 10;
    public static final int GRID_NUM_COLS = 10;

    public ToggleRelativeGridFeature(GridDrawer targetDrawer, ButtonHolderDrawer parentDrawer){
        this.setText("Toggle Grid");
        this.setLayoutY(50);
        
        GridPane gridPane = initializeGridPane();
        
        this.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(!targetDrawer.getChildren().contains(gridPane)){
                    targetDrawer.drawShape(gridPane);
                }
                else {
                    targetDrawer.getChildren().remove(gridPane);
                }
            }
        });
        parentDrawer.drawShape(this);
    }
    
    
    
    private GridPane initializeGridPane () {
        GridPane pane = new GridPane();
        pane.setHgap(GridDrawer.GRID_WIDTH  /GRID_NUM_ROWS);
        pane.setVgap(GridDrawer.GRID_HEIGHT / GRID_NUM_COLS);
        pane.setGridLinesVisible(true);
        pane.add(new Rectangle(), GRID_NUM_ROWS, GRID_NUM_COLS);
        return pane;
    }



    @Override
    public void act () {
        // TODO Auto-generated method stub
        
    }

}
