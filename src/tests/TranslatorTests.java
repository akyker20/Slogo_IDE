package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;
import translator.Translator;
import commandParsing.exceptions.LanguageFileNotFoundException;
import commandParsing.exceptions.PropertyFileAccessException;


public class TranslatorTests {

    @Test
    public void TranslatorRegExTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("enGLIsh");

        assertTrue(t.matchesConstantPattern("50"));
        assertTrue(t.matchesConstantPattern("50.0"));
        assertTrue(t.matchesVariablePattern(":someVar"));
        assertFalse(t.matchesVariablePattern("SEPS"));
        assertFalse(t.matchesCommandPattern("["));

        assertFalse(t
                    .matchesCommandPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesConstantPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesGroupEndPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesGroupStartPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesListEndPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesListStartPattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
        assertFalse(t
                    .matchesVariablePattern("/src/resources/guiResources/turtleImages/default_turtle.png"));
    }

    @Test
    public void EnglishTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("enGLIsh");
        String testString = "fd 50 + 20 20 if less? 0 20 [ sum 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void ChineseTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("chiNEse");
        String testString = "qj 50 + 20 20 ruguo xiao? 0 20 [ jia 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void RussianTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("RuSSiaN");
        String testString = "vr 50 + 20 20 yesli ms 0 20 [ summa 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void FrenchTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("FrENCh");
        String testString = "dev 50 + 20 20 si inferieur? 0 20 [ somme 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void ItalianTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("ItALIan");
        String testString = "avanti 50 + 20 20 se meno? 0 20 [ somma 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void PortugueseTranslationTest () throws LanguageFileNotFoundException,
    PropertyFileAccessException {
        Translator t = new Translator("PoRTUGuesE");
        String testString = "fr 50 + 20 20 se menor? 0 20 [ soma 20 20 ]";
        Iterator<String> testIterator = t.translate(testString);

        assertEquals(testIterator.next(),
                "commandParsing.turtleCommandParsing.turtleMovement.Forward");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "50");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.structuralCommandParsing.If");
        assertEquals(testIterator.next(), "commandParsing.booleanCommandParsing.LessThan");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "0");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "[");
        assertEquals(testIterator.next(), "commandParsing.mathCommandParsing.Sum");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "commandParsing.floatCommandParsing.Constant");
        assertEquals(testIterator.next(), "20");
        assertEquals(testIterator.next(), "]");
        assertFalse(testIterator.hasNext());
    }

}
