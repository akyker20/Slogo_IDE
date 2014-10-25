package tests.commandTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;

import workspaceState.Turtle;
import workspaceState.WorkspaceState;
import commandParsing.CommandParser;
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.LanguageFileNotFoundException;
import commandParsing.exceptions.PropertyFileAccessException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandTester {
	
	protected WorkspaceState workspace;
	protected Iterator<String> commands;
	protected Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();
	
	@Before
	public void setUp() throws Exception {
		setUpStateBeforeTesting("english");
	}
	
	public void setUpTranslator(String language) throws IOException{
		try {
			workspace.translator.createMappingsGivenLanguage(language);
		} catch (LanguageFileNotFoundException | PropertyFileAccessException e) {
			e.printStackTrace();
		};
	}
	
	public void setUpStateBeforeTesting(String language) throws IOException{		
		try {
			workspace = new WorkspaceState();
			workspace.turtles.addTurtle(new Turtle());
		} catch (LanguageFileNotFoundException | PropertyFileAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void setUpCommands(String input){
		commands = workspace.translator.translate(input);
	}
	
	public void resetTesterVariables() {
		objectQueue.clear();
		try {
			setUpStateBeforeTesting("english");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CommandParser createCommand() throws RunTimeNullPointerException, CompileTimeParsingException{
		return CommandParser.createParser(commands.next(), workspace);	
	}
	
	
}
