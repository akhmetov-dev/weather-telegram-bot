import org.openweathermap.API.OpenWeatherMapAPI;
import org.openweathermap.messageStructure.OpenWeatherMapResponse;
import org.telegram.API.TelegramAPI;
import org.telegram.messageStructure.TelegramResponse;

import java.io.*;

public class Starter {
    public static void main(String[] args) throws IOException, InterruptedException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            printFatalError("File config.json could not be read");
            System.exit(0);
        }

        ConfigReader configReader = new ConfigReader(configString);

        TelegramAPI telegramAPI = new TelegramAPI(configReader.getBot_token());

        String response = telegramAPI.getResponse();

        TelegramResponse telegramResponse = new TelegramResponse(response);

        int message_id = telegramResponse.getResult().getMessage().getMessage_id();

        PhraseGenerator phraseGenerator = new PhraseGenerator();

        do {
            response = telegramAPI.getResponse();

            telegramResponse = new TelegramResponse(response);

            if (message_id != telegramResponse.getResult().getMessage().getMessage_id()) {                              // Пришло новое сообщение

                message_id = telegramResponse.getResult().getMessage().getMessage_id();
                telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), phraseGenerator.Greetings() + "\n");

                if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("погода")) {

                    OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI(configReader.getOpen_weather_map_api_key());
                    OpenWeatherMapResponse openWeatherMapResponse = new OpenWeatherMapResponse(openWeatherMapAPI.getWeatherInfo());
//                    TODO: переводчик английского на русский

                    String message = "\uD83C\uDF06 Город: " + "Москва" + "\n" +
                            "\uD83C\uDF21 Температура: " + String.format("%.2f", (openWeatherMapResponse.getMain().getTemp() - 273.15)) + " °C" + "\n" +
                            "\uD83C\uDF21 Чувствуется как: " + String.format("%.2f", (openWeatherMapResponse.getMain().getFeels_like()) - 273.15) + " °C" + "\n" +
                            "Давление: " + openWeatherMapResponse.getMain().getPressure() + " ГПа" + "\n" +
                            "\uD83D\uDCA8 Скорость ветра: " + openWeatherMapResponse.getWind().getSpeed() + " м/с" + "\n" +
                            "\uD83D\uDCA6 Влажность: " + openWeatherMapResponse.getMain().getHumidity() + " %" + "\n";

                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), message);

                } else if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("настройки")) {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(),
                            "Скоро добавим и настроечки!");
                } else {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(),
                            "\uD83D\uDE11 Я тебя не понимаю...");
                }
            }
            Thread.sleep(100);
        } while (true);
    }
    public static void printFatalError(String message) {
        System.out.println("FATAL" + message);
    }
}