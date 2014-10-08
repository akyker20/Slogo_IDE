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

public class Translator {

	private Map<String, String> dictionary = new HashMap<String, String>();
	private Map<String, String> classDictionary = new HashMap<String, String>();
	private Map<String, String> languageToClassPath = new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception{
		Translator test = new Translator("Chinese");
		test.translate("jia 30 :someVar [");
	}
	
	public Translator(String language) throws IOException {
		changeLanguage(language);
		getClassNamesInPackage("SLOGOStanley.jar", "commandParsing");
		mapLanguageToClassPath();
	}

	public Iterator<String> translate(String commands){
		
		String[] splitString = commands.split(" ");
		List<String> translatedString = new ArrayList<String>();
		
		for(String s : splitString){
			if(stringRepresentsNumber(s) | "[]".contains(s)){
				translatedString.add(s);
			}
			else{
				translatedString.add(languageToClassPath.get(s));
			}
		}
		
		System.out.println(translatedString);
		
		return translatedString.iterator();
		
	}
	
	protected boolean stringRepresentsNumber(String string){
		return isStringParsableAsFloat(string) | isStringParsableAsVariable(string);
	}
	
	private boolean isStringParsableAsVariable(String string) {
		return string.charAt(0)==':';
	}

	protected boolean isStringParsableAsFloat(String string){
		boolean isParseable = true;
		int numDelimiters = 0;
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)=='.'){
				numDelimiters++;
			}
			if(!Character.isDigit(string.charAt(i)) & string.charAt(i) != '.'){
				isParseable = false;
			}
		}
		if(numDelimiters>1){
			isParseable = false;
		}
		return isParseable;
	}

	private void mapLanguageToClassPath() throws FileNotFoundException, IOException{
		dictionary.keySet().stream().forEach((k) -> {
			languageToClassPath.put(k, classDictionary.get(dictionary.get(k)));
		});
		System.out.println(languageToClassPath);
	}

	private void changeLanguage(String language) throws FileNotFoundException, IOException {
		
		String augmentedFileName = language.substring(0,1).toUpperCase() + language.substring(1).toLowerCase();
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/languages/" + augmentedFileName + ".properties")));
		String inputLine = null;
		while ((inputLine = reader.readLine()) != null) {

			inputLine = inputLine.replace(" ", "");

			String[] commands = inputLine.split("=");

			// Ignore empty lines and comment lines
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
		// Printing all words stored in the map.
		for (String key : dictionary.keySet()) {
			System.out.println(key + ": " + dictionary.get(key));
		}
		
		reader.close();
	}
	
	private void getClassNamesInPackage(String jarName,
			String packageName) throws FileNotFoundException, IOException {
		packageName = packageName.replaceAll("\\.", "/");
			JarInputStream jarFile = new JarInputStream(new FileInputStream(
					jarName));
			JarEntry jarEntry;

			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if ((jarEntry.getName().startsWith(packageName))
						&& (jarEntry.getName().endsWith(".class"))) {
					String pathName = jarEntry.getName().replaceAll("/", "\\.");
					

					classDictionary.put(findCommandName(pathName), clipPathName(pathName));
				}
			}
			jarFile.close();
			System.out.println(classDictionary);
	}
	
	private static String findCommandName(String command) {

		String folders[] = command.split("\\.");

		return folders[folders.length - 2];

	}
	
	private static String clipPathName(String command) {

		return command.substring(0, command.length()-6);

	}

}
