package translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Translator {

    private Map<String, String> dictionary = new HashMap<String, String>();
    private String myString;

    protected int readChars (Scanner s) {
        myString = s.useDelimiter("\\Z").next();
        s.close();
        System.out.println(s);
        return myString.length();
    }

    public Translator (String language, String translateText) throws FileNotFoundException {

        // translateText.
        //
        // translateText.indexOf(ch, fromIndex);
        // translateText.

        // readChars(s)
        // Scanner sc = new Scanner(System.in);
        // int i = sc.nextInt();

        new Scanner(new File("src/Test.txt"));

        Scanner sc = new Scanner(new File("src/resources/languages/English.properties"));
        while (sc.hasNextLong()) {
            long aLong = sc.nextLong();
            System.out.println(aLong);
        }
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();

    }

    // for (int i=0; i<50; i++){
    //
    // }
    // }

    public Map<String, String> getDictionary (Map<String, String> dictionary) {
        return dictionary;
    }

}
