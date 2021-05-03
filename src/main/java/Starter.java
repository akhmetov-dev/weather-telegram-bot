import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("Input token_bot: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bot_token = reader.readLine();

        TelegramAPI telegramAPI = new TelegramAPI(bot_token);
        TelegramResponse telegramResponse = new TelegramResponse(telegramAPI.getResponse());
        int message_id = telegramResponse.result.message.message_id;
        while (true) {
            telegramResponse = new TelegramResponse(telegramAPI.getResponse());
            if (message_id != telegramResponse.result.message.message_id) {
                message_id = telegramResponse.result.message.message_id;
                if (telegramResponse.result.message.text.equalsIgnoreCase("погода")) {
                    telegramAPI.sendMessage(telegramResponse.result.message.chat.id, "\uD83C\uDF1E Погодка нынче хорошая");
                } else if (telegramResponse.result.message.text.equalsIgnoreCase("настройки")) {
                    telegramAPI.sendMessage(telegramResponse.result.message.chat.id, "Скоро добавим и настроечки!");
                } else {
                    telegramAPI.sendMessage(telegramResponse.result.message.chat.id, "\uD83D\uDE11 Я тебя не понимаю...");
                }
            }
            Thread.sleep(100);
        }
    }
}