package gui.factories;

public class FactoryInitializer {

    // Probably put in a config file eventually
    public static final String LINE_FACTORY = "LineFactory";
    public static final String TURTLE_FACTORY = "TurtleFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init () {
        return new ObjectFactory[] {
                                    new LineFactory(LINE_FACTORY),
                                    new TurtleFactory(TURTLE_FACTORY)

        };
    }

}
