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

public class Translator {

	private static final String CONSTANT = "Constant";
	private static final String VARIABLE = "Variable";
	private static final String USER_DEFINED_COMMAND = "UserInstruction";
	private Map<String, String> dictionary = new HashMap<String, String>();
	private Map<String, String> classDictionary = new HashMap<String, String>();
	private Map<String, String> languageToClassPath = new HashMap<String, String>();
	private Map<String, String> syntaxDictionary = new HashMap<String, String>();

	public Translator(String language) throws IOException {
		changeLanguage(language);
		getClassNamesInPackage("SLOGO.jar", "commandParsing");
		mapLanguageToClassPath();
	}

	public Iterator<String> translate(String commands) {
		return translateToList(commands).iterator();
	}

	public List<String> translateToList(String string) {
		String[] splitString = string.split(" ");
		List<String> translatedString = new ArrayList<String>();

		for (String s : splitString) {
			if (dictionary.containsKey(s)) {
				translatedString.add(languageToClassPath.get(s));
			} else if (s.matches(syntaxDictionary.get("Command")) && !languageToClassPath.containsKey(s)) {
				translatedString.add(languageToClassPath.get(USER_DEFINED_COMMAND));
				translatedString.add(s);
			} else if (s.matches(syntaxDictionary.get("Constant"))) {
				translatedString.add(languageToClassPath.get(CONSTANT));
				translatedString.add(s);
			} else if (s.matches(syntaxDictionary.get("Variable"))) {
				translatedString.add(languageToClassPath.get(VARIABLE));
				translatedString.add(s);
			} else {
				translatedString.add(s);
			}
		}
		return translatedString;
	}

	private void mapLanguageToClassPath() throws FileNotFoundException, IOException {
		dictionary.keySet().stream().forEach((k) -> {
			languageToClassPath.put(k, classDictionary.get(dictionary.get(k)));
		});
	}

	private void changeLanguage(String language) throws FileNotFoundException, IOException {
		String augmentedFileName = language.substring(0, 1).toUpperCase()
				+ language.substring(1).toLowerCase();
		Scanner scan = new Scanner(this.getClass().getResourceAsStream(
				"/resources/languages/" + augmentedFileName + ".properties"));
		String inputLine = scan.nextLine();
		while (((scan.hasNextLine()) != false) && (inputLine.contains("syntax") == false)) {
			inputLine = scan.nextLine();
			inputLine = inputLine.replace(" ", "");
			String[] commands = inputLine.split("=");

			if (inputLine.equals("") || inputLine.startsWith("#"))
				continue;
			if (inputLine.contains(",")) {
				String[] multipleCommandsOneAction = commands[1].split(",");
				for (int i = 0; i < multipleCommandsOneAction.length; i++) {
					dictionary.put(multipleCommandsOneAction[i], commands[0]);
				}
			} else {
				dictionary.put(commands[1], commands[0]);
			}
		}
		dictionary.put(CONSTANT, CONSTANT);
		dictionary.put(VARIABLE, VARIABLE);
		dictionary.put(USER_DEFINED_COMMAND, USER_DEFINED_COMMAND);

		while ((scan.hasNextLine()) != false) {
			inputLine = scan.nextLine();
			inputLine = inputLine.replace(" ", "");
			String[] commands = inputLine.split("=");

			if (inputLine.equals("") || inputLine.startsWith("#"))
				continue;
			syntaxDictionary.put(commands[0], commands[1]);
		}

	}

	private void getClassNamesInPackage(String jarName, String packageName) throws FileNotFoundException,
			IOException {
		packageName = packageName.replaceAll("\\.", "/");
		JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
		JarEntry jarEntry;

		while (true) {
			jarEntry = jarFile.getNextJarEntry();
			if (jarEntry == null) {
				break;
			}
			if ((jarEntry.getName().startsWith(packageName)) && (jarEntry.getName().endsWith(".class"))) {
				String pathName = jarEntry.getName().replaceAll("/", "\\.");
				classDictionary.put(findCommandName(pathName), clipPathName(pathName));
			}
		}
		jarFile.close();
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

	public String getVariablePattern() {
		return syntaxDictionary.get("Variable");
	}

	public String getConstantPattern() {
		return syntaxDictionary.get("Constant");
	}

	public String getCommandPattern() {
		return syntaxDictionary.get("Command");
	}

	public String getListStartPattern() {
		return syntaxDictionary.get("ListStart");
	}

	public String getListEndPattern() {
		return syntaxDictionary.get("ListEnd");
	}

}
