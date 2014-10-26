package gui.nonbuttonfeatures;
import XML.readers.SavedWorkspaceXMLReader;
import XML.workspaceparams.WorkspaceScreenParameters;
import gui.componentdrawers.TurtleScreenDrawer;
import javafx.scene.layout.Pane;
/**
 * This is the grid. The reason it is a feature is that we may make
 * it interactive in the future - for instance click to draw another
 * turtle
 * @author Austin Kyker
 *
 */
public class TurtleScreenFeature extends Pane {
    
    private static final String COLOR = SavedWorkspaceXMLReader.COLOR;
    private static final String TOGGLE_GRID = SavedWorkspaceXMLReader.TOGGLE_GRID;
    
    
    public TurtleScreenFeature(TurtleScreenDrawer parentDrawer, WorkspaceScreenParameters screenParams){
        this.setPrefWidth(TurtleScreenDrawer.GRID_WIDTH);
        this.setPrefHeight(TurtleScreenDrawer.GRID_HEIGHT);
        this.getStyleClass().add("grid");
        this.setLayoutY(20);
        parentDrawer.setTurtleScreenFeature(this);

        if(screenParams.extractParams(TOGGLE_GRID).equalsIgnoreCase("true")){
            parentDrawer.toggleGrid();
        }
        if(screenParams.hasParam(COLOR)) {
            parentDrawer.changeScreenColor("-fx-background-color: " + screenParams.extractParams(COLOR));
        }
    }
}