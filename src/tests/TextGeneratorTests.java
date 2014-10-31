package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import gui.mainclasses.TextGenerator;

//This entire file is part of my masterpiece.
//Allan Kiplagat

public class TextGeneratorTests {
    TextGenerator textGen = TextGenerator.getInstance();

    @Test
    public void testInstance() {
        assertTrue(textGen instanceof TextGenerator);
    }
    
    @Test
    public void testEnglishSupported() {
        assertTrue(textGen.languageSupported(textGen.ENGLISH));
    }  

    @Test
    public void testEnglish() {
        textGen.setLanguage(textGen.ENGLISH);
        assertTrue("File".equals(textGen.get(textGen.FILE)));
    }
    
    @Test
    public void testFrenchSupported() {
        assertTrue(textGen.languageSupported(textGen.FRENCH));
    }    
    
    @Test
    public void testFrench() {
        textGen.setLanguage(textGen.FRENCH);
        assertTrue("Dossier".equals(textGen.get(textGen.FILE)));
    } 
    
}
