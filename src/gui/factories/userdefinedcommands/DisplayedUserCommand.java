package gui.factories.userdefinedcommands;

/**
 * Class encapsulates a user-defined command displayed in the GUI. A
 * table-view is used to display these commands to the user.
 * @author akyker20, allankiplagat
 *
 */
public class DisplayedUserCommand {
    
    private String myName;
    private String myParams;
    private String myContent;

    /**
     * Constructor
     * @param name of the function
     * @param params, inputs to the function
     * @param content, the content of the function
     */
    public DisplayedUserCommand (String name, String params, String content) {
        myName = name;
        myParams = params;
        myContent = content;
    }

    public String getMyName () {
        return myName;
    }

    public String getMyParams () {
        return myParams;
    }

    public String getMyContent () {
        return myContent;
    }

    public void setMyParams (String params) {
        myParams = params;
    }

    public void setMyContent (String content) {
        myContent = content;
    }
}
