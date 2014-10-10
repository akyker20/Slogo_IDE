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
import commandParsing.exceptions.CompileTimeParsingException;
import commandParsing.exceptions.RunTimeNullPointerException;
import drawableobject.DrawableObject;

public abstract class CommandTester {
	
	protected State state;
	protected Iterator<String> commands;
	protected Queue<DrawableObject> objectQueue = new LinkedList<DrawableObject>();
	
	@Before
	public void setUp() throws Exception {
		setUpStateBeforeTesting("english");
	}
	
	public Translator setUpTranslator(String language) throws IOException{
		return new Translator(language);
	}
	
	public void setUpStateBeforeTesting(String language) throws IOException{		
		state = new State(new Turtle(), new HashMap<String, Double>(), setUpTranslator(language));
	}
	
	public void setUpCommands(String input){
		commands = state.translate(input);
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
		return CommandParser.createParser(commands.next(), state);	
	}
	
	
}
