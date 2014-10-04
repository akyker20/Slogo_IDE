package GUI;


public class GridDrawer extends ComponentDrawer {
    
    public static final double GRID_WIDTH_RATIO = .667;
    public static final double GRID_HEIGHT_RATIO = .8;
    public static final double GRID_WIDTH = GUIInitializer.SCREEN_WIDTH*GRID_WIDTH_RATIO;
    public static final double GRID_HEIGHT = GUIInitializer.SCREEN_HEIGHT*GRID_HEIGHT_RATIO;

    public GridDrawer() {
        super();
        this.getStyleClass().add("gridPane");
        this.setPrefSize(GRID_WIDTH, GRID_HEIGHT);
    }
}
