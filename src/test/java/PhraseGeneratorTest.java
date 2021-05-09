import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhraseGeneratorTest {

    @Test
    public void greetingsTest() {
        PhraseGenerator phraseGenerator = new PhraseGenerator();

        ArrayList<String> greetings = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            greetings.add(phraseGenerator.Greetings());
        }

        assertEquals(true, greetings.contains("Привет!"));
        assertEquals(true, greetings.contains("Добрый день!"));
        assertEquals(true, greetings.contains("Здравствуй, друг!"));
        assertEquals(true, greetings.contains("Приветствую!"));
        assertEquals(true, greetings.contains("Хорошего дня!"));
        assertEquals(true, greetings.contains("Давно не виделись!"));
    }
}