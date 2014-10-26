package XML.workspaceparams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkspacePenCommands implements Iterable<String> {
    
    private List<String> myCommands;
    
    public WorkspacePenCommands(){
        myCommands = new ArrayList<String>();
    }
    
    public void addCommand(String str){
        myCommands.add(str);
    }

    @Override
    public Iterator<String> iterator () {
        return myCommands.iterator();
    }

}
