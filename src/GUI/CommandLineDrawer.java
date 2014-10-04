package GUI;

public class CommandLineDrawer extends ComponentDrawer {

    public CommandLineDrawer() {
        super();
        this.getStyleClass().add("commandLine");
        this.setPrefWidth(GUIInitializer.SCREEN_WIDTH*GridDrawer.GRID_WIDTH_RATIO);
    }

}
