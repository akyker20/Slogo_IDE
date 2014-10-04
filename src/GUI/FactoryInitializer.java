package GUI;

public class FactoryInitializer {

    //Probably put in a config file eventually
    public static final String LINE_FACTORY = "LineFactory";

    /**
     * Makes the object factories
     * @return an array of object factories
     */
    public static ObjectFactory[] init(){
        return new ObjectFactory[]{
                                   new LineFactory(LINE_FACTORY),
        };
    }

}
