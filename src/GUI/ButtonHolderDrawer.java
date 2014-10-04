package GUI;

public class ButtonHolderDrawer extends ComponentDrawer {
    
    public static final double OPTIONS_WIDTH_RATIO = .333;
    
    public ButtonHolderDrawer(String name) {
        super(name);
        this.getStyleClass().add("buttonHolder");
        this.setPrefWidth(GUIInitializer.SCREEN_WIDTH*OPTIONS_WIDTH_RATIO);
    }
}
