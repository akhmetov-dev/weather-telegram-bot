public class PhraseGenerator {
    private final String[] greetings = {"Привет!", "Добрый день!", "Здравствуй, друг!",
            "Приветствую!", "Хорошего дня!", "Давно не виделись!"};
    public String Greetings() {
        return greetings[(int)(Math.random() * 6)];
    }
}
