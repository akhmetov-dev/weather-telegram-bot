package org;

public class PhraseGenerator {
    private final String[] greetings = {"Привет!\n", "Добрый день!\n", "Здравствуй, друг!\n", "Приветствую!\n", "Хорошего дня!\n", "Давно не виделись!\n"};
    public String Greetings() {
        return greetings[(int)(Math.random() * 5)];
    }
}
