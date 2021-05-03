import org.telegram.messageStructure.TelegramResponse;

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
        int message_id = telegramResponse.getResult().getMessage().getMessage_id();
        while (true) {
            telegramResponse = new TelegramResponse(telegramAPI.getResponse());
            if (message_id != telegramResponse.getResult().getMessage().getMessage_id()) {
                message_id = telegramResponse.getResult().getMessage().getMessage_id();
                if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("погода")) {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), "\uD83C\uDF1E Погодка нынче хорошая");
                } else if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("настройки")) {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), "Скоро добавим и настроечки!");
                } else {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), "\uD83D\uDE11 Я тебя не понимаю...");
                }
            }
            Thread.sleep(100);
        }
    }
}