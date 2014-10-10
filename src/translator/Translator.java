package translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.stream.Collectors;

import commandParsing.exceptions.RunTimeNullPointerException;

import api.classes.CommandParser;

public class Translator {
	
	private Map<String, String> dictionary = new HashMap<String, String>();
	private Map<String, String> classDictionary = new HashMap<String, String>();
	private Map<String, String> languageToClassPath = new HashMap<String, String>();
	private Map<String, String> syntaxDictionary = new HashMap<String,String>();
	
	public Translator(String language) throws IOException {
		changeLanguage(language);
		getClassNamesInPackage("SLOGO.jar", "commandParsing");
		mapLanguageToClassPath();
	}

	public Iterator<String> translate(String commands){
		
		String[] splitString = commands.split(" ");
		List<String> translatedString = new ArrayList<String>();
		
		for(String s : splitString){
			if(dictionary.containsKey(s)){
				translatedString.add(languageToClassPath.get(s));
			}
			else{
				translatedString.add(s);
			}
		}
		return translatedString.iterator();
	}

	private void mapLanguageToClassPath() throws FileNotFoundException, IOException{
		dictionary.keySet().stream().forEach((k) -> {
			languageToClassPath.put(k, classDictionary.get(dictionary.get(k)));
		});
	}

	private void changeLanguage(String language) throws FileNotFoundException, IOException {
		String augmentedFileName = language.substring(0,1).toUpperCase() + language.substring(1).toLowerCase();
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/languages/" + augmentedFileName + ".properties")));
		String inputLine = null;
		while (((inputLine = reader.readLine()) != null) && (inputLine.contains("syntax") == false)) {
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
		while ((inputLine = reader.readLine()) != null) {
			inputLine = inputLine.replace(" ", "");
			String[] commands = inputLine.split("=");
			
			if (inputLine.equals("") || inputLine.startsWith("#"))
				continue;
			
			syntaxDictionary.put(commands[0], commands[1]);
			
			
		}

		reader.close();
	}
	
	private void getClassNamesInPackage(String jarName,
			String packageName) throws FileNotFoundException, IOException {packageName = packageName.replaceAll("\\.", "/");
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
		return command.substring(0, command.length()-6);
	}
}
