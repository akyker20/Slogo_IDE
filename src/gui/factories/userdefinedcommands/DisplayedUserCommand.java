package gui.factories.userdefinedcommands;

public class DisplayedUserCommand {
    private String myName;
    private String myParams;
    private String myContent;
    
    public DisplayedUserCommand(String name, String params, String content){
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
}
