package GUI;


public class GridDrawer extends ComponentDrawer {
    
    public static final double GRID_WIDTH_RATIO = .667;

    public GridDrawer() {
        super();
        this.getStyleClass().add("gridPane");
        this.setPrefWidth(GUIInitializer.SCREEN_WIDTH*GRID_WIDTH_RATIO);
    }
}
