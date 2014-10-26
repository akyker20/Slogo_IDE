package gui.mainclasses.workspace;

import gui.factories.userdefinedcommands.DisplayedUserCommand;
import gui.nonbuttonfeatures.tableviews.ColorIndex;
import gui.variableslist.WorkspaceVariable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkspaceDataHolder {
    private ObservableList<WorkspaceVariable> myVariablesList;
    private ObservableList<String> myPreviousCommandsList;
    private ObservableList<DisplayedUserCommand> myUserDefinedCommandList;
    private ObservableList<String> mySavedCommandsList;
    private ObservableList<ColorIndex> myColorIndexList;
    
    /**
     * Default constructor
     */
    public WorkspaceDataHolder(){
        this(FXCollections.observableArrayList(),
             FXCollections.observableArrayList(),
             FXCollections.observableArrayList(),
             FXCollections.observableArrayList(),
             FXCollections.observableArrayList());
    }
    
    /**
     * 
     * @param myVariablesList
     * @param myPreviousCommandsList
     * @param myUserDefinedCommandList
     * @param mySavedCommandsList
     * @param myColorIndexList
     */
    public WorkspaceDataHolder(ObservableList<WorkspaceVariable> myVariablesList,
                               ObservableList<String> myPreviousCommandsList,
                               ObservableList<DisplayedUserCommand> myUserDefinedCommandList,
                               ObservableList<String> mySavedCommandsList,
                               ObservableList<ColorIndex> myColorIndexList) {
        this.myVariablesList = myVariablesList;
        this.myPreviousCommandsList = myPreviousCommandsList;
        this.myUserDefinedCommandList = myUserDefinedCommandList;
        this.mySavedCommandsList = mySavedCommandsList;
        this.myColorIndexList = myColorIndexList;
    }

    public ObservableList<WorkspaceVariable> getMyVariablesList () {
        return myVariablesList;
    }


    public ObservableList<String> getMyPreviousCommandsList () {
        return myPreviousCommandsList;
    }

    public ObservableList<DisplayedUserCommand> getMyUserDefinedCommandList () {
        return myUserDefinedCommandList;
    }

    public ObservableList<String> getMySavedCommandsList () {
        return mySavedCommandsList;
    }

    public ObservableList<ColorIndex> getMyColorIndexList () {
        return myColorIndexList;
    }

    public void clear () {
        myVariablesList.clear();
        myPreviousCommandsList.clear();
        myUserDefinedCommandList.clear();
        mySavedCommandsList.clear();
        myColorIndexList.clear();
    }   
}