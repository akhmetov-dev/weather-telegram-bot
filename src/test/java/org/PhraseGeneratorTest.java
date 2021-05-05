package org;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhraseGeneratorTest {

    @Test
    public void greetings() {
        PhraseGenerator phraseGenerator = new PhraseGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(phraseGenerator.Greetings());
        }
    }
}