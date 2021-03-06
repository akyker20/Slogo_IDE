package translator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.stream.Collectors;
import commandParsing.exceptions.LanguageFileNotFoundException;
import commandParsing.exceptions.PropertyFileAccessException;


/**
 * This file deals with translating the commands in different languages to Strings 
 * that our parser can actually work with and deal with. 
 * 
 * 
 * @author Stanley Yuan, Steve Kuznetsov
 *
 */

public class Translator {

	private static final String CONSTANT = "Constant";
	private static final String VARIABLE = "Variable";
	private static final String USER_DEFINED_COMMAND = "UserInstruction";
	private static final String JAR_NAME = "SLOGO.jar";
	private static final String COMMAND_PACKAGE_NAME = "commandParsing";
	private Map<String, String> dictionaryLanguageToEnglish = new HashMap<String, String>();
	private Map<String, String> dictionaryOfClassNameToPath = new HashMap<String, String>();
	private Map<String, String> dictionaryOfLanguageToClassPath = new HashMap<String, String>();
	private Map<String, String> syntaxDictionary = new HashMap<String, String>();
	private Map<String, String> reverseMapping = new HashMap<String,String>();


	public Translator(String language) throws LanguageFileNotFoundException, PropertyFileAccessException {
		createMappingsGivenLanguage(language);
	}
	
	/**
	 * Creating a few different maps, it creates a mapping of the language to what we actually need.
	 * It takes in a language as a String.
	 * @param language 
	 * @throws LanguageFileNotFoundException
	 * @throws PropertyFileAccessException
	 */
	
	public void createMappingsGivenLanguage(String language) throws LanguageFileNotFoundException, PropertyFileAccessException{
		buildDictionaryOfCommandsToEnglish(language);
		buildMapOfCommandPaths();
		mapLanguageToClassPath();
		createReverseMapping();
	}

	public Iterator<String> translate(String commands) {
		return translateToList(commands).iterator();
	}

	public List<String> translateToList(String string) {
		String[] splitString = string.split(" ");
		List<String> translatedString = new ArrayList<String>();

		for (String s : splitString) {
			String potentialCommandName = s.toLowerCase();
			if (dictionaryLanguageToEnglish.containsKey(potentialCommandName)) {
				translatedString.add(dictionaryOfLanguageToClassPath.get(potentialCommandName));
			} else if (matchesCommandPattern(s) && !dictionaryOfLanguageToClassPath.containsKey(potentialCommandName)) {
				translatedString.add(dictionaryOfLanguageToClassPath.get(USER_DEFINED_COMMAND));
				translatedString.add(s);
			} else if (matchesConstantPattern(s)) {
				translatedString.add(dictionaryOfLanguageToClassPath.get(CONSTANT));
				translatedString.add(s);
			} else if (matchesVariablePattern(s)) {
				translatedString.add(dictionaryOfLanguageToClassPath.get(VARIABLE));
				translatedString.add(s);
			} else {
				translatedString.add(s);
			}
		}
		return translatedString;
	}
	
	public String reverseTranslate(List<String> strings){
		for(String s : strings){
			if(!reverseMapping.containsKey(s)){
				reverseMapping.put(s, s);
			}
		}
		return strings.stream()
			      	  .map(s -> reverseMapping.get(s))
			      	  .filter(s -> s.length()>0)
			      	  .collect(Collectors.joining(" "));
	}

	private void mapLanguageToClassPath() {
		dictionaryLanguageToEnglish.keySet().stream().forEach((k) -> {
			dictionaryOfLanguageToClassPath.put(k, dictionaryOfClassNameToPath.get(dictionaryLanguageToEnglish.get(k)));
		});
	}

	private void buildDictionaryOfCommandsToEnglish(String language) {
		String augmentedFileName = language.substring(0, 1).toUpperCase()
				+ language.substring(1).toLowerCase();
		Scanner scan = new Scanner(this.getClass().getResourceAsStream(
				"/resources/languages/" + augmentedFileName + ".properties"));
		String inputLine = scan.nextLine();
		while (scan.hasNextLine() && !inputLine.contains("Syntax")) {
			inputLine = scan.nextLine();
			inputLine = inputLine.replace(" ", "");
			String[] commands = inputLine.split("=");

			if (inputLine.equals("") || inputLine.startsWith("#"))
				continue;
			if (inputLine.contains("|")) {
				String[] multipleCommandsOneAction = commands[1].split("\\|");
				for (int i = 0; i < multipleCommandsOneAction.length; i++) {
					dictionaryLanguageToEnglish.put(multipleCommandsOneAction[i].toLowerCase(), commands[0]);
				}
			} else {
				dictionaryLanguageToEnglish.put(commands[1], commands[0]);
			}
		}
		dictionaryLanguageToEnglish.put(CONSTANT, CONSTANT);
		dictionaryLanguageToEnglish.put(VARIABLE, VARIABLE);
		dictionaryLanguageToEnglish.put(USER_DEFINED_COMMAND, USER_DEFINED_COMMAND);

		while (scan.hasNextLine()) {
			inputLine = scan.nextLine();
			inputLine = inputLine.replace(" ", "");
			String[] commands = inputLine.split("=");

			if (inputLine.equals("") || inputLine.startsWith("#")){
				continue;
			}
			syntaxDictionary.put(commands[0], commands[1]);
		}

	}

	private void buildMapOfCommandPaths() throws LanguageFileNotFoundException, PropertyFileAccessException {
		JarInputStream jarFile;
		try {
			jarFile = new JarInputStream(new FileInputStream(JAR_NAME));
		} catch (FileNotFoundException e) {
			throw new LanguageFileNotFoundException();
		} catch (IOException e) {
			throw new PropertyFileAccessException();
		}
		JarEntry jarEntry;

		while (true) {
			try {
				jarEntry = jarFile.getNextJarEntry();
			} catch (IOException e) {
				throw new PropertyFileAccessException();
			}
			if (jarEntry == null) {
				break;
			}
			if ((jarEntry.getName().startsWith(COMMAND_PACKAGE_NAME))
					&& (jarEntry.getName().endsWith(".class"))) {
				String pathName = jarEntry.getName().replaceAll("/", "\\.");
				dictionaryOfClassNameToPath.put(findCommandName(pathName), clipPathName(pathName));
			}
		}
		try {
			jarFile.close();
		} catch (IOException e) {
			throw new PropertyFileAccessException();
		}
	}
	
	private void createReverseMapping() {
		dictionaryOfLanguageToClassPath.entrySet()
									 .stream()
									 .forEach(e -> {
										 reverseMapping.put(e.getValue(), e.getKey());
									 });
		reverseMapping.put(dictionaryOfLanguageToClassPath.get(USER_DEFINED_COMMAND), "");
		reverseMapping.put(dictionaryOfLanguageToClassPath.get(CONSTANT), "");
		reverseMapping.put(dictionaryOfLanguageToClassPath.get(VARIABLE), "");
	}

	private static String findCommandName(String command) {
		String folders[] = command.split("\\.");
		return folders[folders.length - 2];
	}

	private static String clipPathName(String command) {
		return command.substring(0, command.length() - 6);
	}

	public boolean matchesVariablePattern(String str) {
		return str.matches(syntaxDictionary.get("Variable"));
	}

	public boolean matchesConstantPattern(String str) {
		return str.matches(syntaxDictionary.get("Constant"));
	}

	public boolean matchesCommandPattern(String str) {
		return str.matches(syntaxDictionary.get("Command"));
	}

	public boolean matchesListStartPattern(String str) {
		return str.matches(syntaxDictionary.get("ListStart"));
	}

	public boolean matchesListEndPattern(String str) {
		return str.matches(syntaxDictionary.get("ListEnd"));
	}

	public boolean matchesGroupStartPattern(String str) {
		return str.matches(syntaxDictionary.get("GroupStart"));
	}

	public boolean matchesGroupEndPattern(String str) {
		return str.matches(syntaxDictionary.get("GroupEnd"));
	}
}
