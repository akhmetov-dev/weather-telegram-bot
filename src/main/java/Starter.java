import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("Input token_bot: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bot_token = reader.readLine();

        TelegramAPI telegramAPI = new TelegramAPI(bot_token);
        TelegramResponse telegramResponse;
        int message_id = 0;
        while (true) {
            telegramResponse = new TelegramResponse(telegramAPI.getResponse());
            if (message_id != telegramResponse.result.message.message_id) {
                message_id = telegramResponse.result.message.message_id;
                System.out.println("From : " + telegramResponse.result.message.from.first_name);
                System.out.println("Message : " + telegramResponse.result.message.text);
                telegramAPI.sendMessage(telegramResponse.result.message.chat.id, telegramResponse.result.message.text);
            }
            Thread.sleep(100);
        }
    }
}