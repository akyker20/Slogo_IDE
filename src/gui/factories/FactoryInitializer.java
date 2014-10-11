package gui.factories;

public class FactoryInitializer {

    // Probably put in a config file eventually
    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";
    public static final String ERROR_POPUP_FACTORY = "ErrorPopupFactory";
    public static final String CLEAR_GRID_FACTORY = "ClearGridFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init () {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY),
                                    new ErrorPopupFactory(ERROR_POPUP_FACTORY),
                                    new EmptyPaneFactory(CLEAR_GRID_FACTORY)
        };
    }

}
