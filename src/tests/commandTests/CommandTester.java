package tests.commandTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;

import state.State;
import state.Turtle;
import translator.Translator;
import commandParsing.CommandParser;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandTester {
	
	protected State state;
	protected Iterator<String> commands;
	protected Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();
	private Translator translator;
	
	@Before
	public void setUp() throws Exception {
		setUpStateBeforeTesting();
		setUpTranslator("english");
	}
	
	public void setUpStateBeforeTesting(){		
		state = new State(new Turtle(), new HashMap<String, Float>());
	}
	
	public void setUpTranslator(String language) throws IOException{
		translator = new Translator(language);
	}
	
	public void setUpCommands(String input){
		commands = translator.translate(input);
	}
	
	public void clearQueue(){
		objectQueue.clear();
	}
	
	public CommandParser createCommand() throws RunTimeNullPointerException{
		return CommandParser.createParser(commands.next(), state);	
	}
	
	
}
