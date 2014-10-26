package gui.factories.userdefinedcommands;

public class DisplayedUserCommand {
    private String myName;
    private String myParams;
    
    public DisplayedUserCommand(String name, String params){
        myName = name;
        myParams = params;
    }

    public String getMyName () {
        return myName;
    }

    public String getMyParams () {
        return myParams;
    }
}
