package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import translator.Translator;


public class TranslatorTests {
	
	@Test
	public void TranslatorRegExTest() throws IOException{
		Translator t = new Translator("enGLIsh");
		
		assertTrue(t.matchesConstantPattern("50"));
		assertTrue(t.matchesConstantPattern("50.0"));
		assertTrue(t.matchesVariablePattern(":someVar"));
		assertFalse(t.matchesCommandPattern("["));
	}

	@Test
	public void EnglishTranslationTest() throws IOException {
		Translator t = new Translator("enGLIsh");
		String testString = "fd 50 + 20 20 if less? 0 20 [ sum 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);

		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
	public void ChineseTranslationTest() throws IOException {
		Translator t = new Translator("chiNEse");
		String testString = "qj 50 + 20 20 ruguo xiao? 0 20 [ jia 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);
		
		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
	public void RussianTranslationTest() throws IOException {
		Translator t = new Translator("RuSSiaN");
		String testString = "vr 50 + 20 20 yesli ms 0 20 [ summa 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);
		
		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
	public void FrenchTranslationTest() throws IOException {
		Translator t = new Translator("FrENCh");
		String testString = "dev 50 + 20 20 si inferieur? 0 20 [ somme 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);
		
		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
	public void ItalianTranslationTest() throws IOException {
		Translator t = new Translator("ItALIan");
		String testString = "avanti 50 + 20 20 se meno? 0 20 [ somma 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);
		
		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
	public void PortugueseTranslationTest() throws IOException {
		Translator t = new Translator("PoRTUGuesE");
		String testString = "fr 50 + 20 20 se menor? 0 20 [ soma 20 20 ]";
		Iterator<String> testIterator = t.translate(testString);
		
		assertEquals(testIterator.next(), "commandParsing.turtleCommandParsing.Forward");
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
