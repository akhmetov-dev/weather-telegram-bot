import org.openweathermap.API.OpenWeatherMapAPI;
import org.openweathermap.messageStructure.OpenWeatherMapResponse;
import org.telegram.API.TelegramAPI;
import org.telegram.messageStructure.TelegramResponse;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;

public class Starter {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
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
            ColorPrinter.printFatalError("File config.json could not be read");
            System.exit(0);
        }

        ConfigReader configReader = new ConfigReader(configString);

        TelegramAPI telegramAPI = new TelegramAPI(configReader.getBot_token());

        String response = telegramAPI.getResponse();

        TelegramResponse telegramResponse = new TelegramResponse(response);

        boolean responseIsNull = Objects.isNull(telegramResponse.getResult());
        if (responseIsNull) {
            ColorPrinter.printWarning("There is no messages for the last 24 hours.");
            while (Objects.isNull(telegramResponse.getResult())) {
                response = telegramAPI.getResponse();
                telegramResponse = new TelegramResponse(response);
            }
        }


        int message_id = telegramResponse.getResult().getMessage().getMessage_id();

        PhraseGenerator phraseGenerator = new PhraseGenerator();

        DatabaseApi databaseApi = new DatabaseApi(configReader.getPostgres_url(), configReader.getPostgres_user(), configReader.getPostgres_pass());

        do {
            response = telegramAPI.getResponse();

            telegramResponse = new TelegramResponse(response);

            responseIsNull = Objects.isNull(telegramResponse.getResult());

            if (responseIsNull) {
                ColorPrinter.printWarning("There is no messages for the last 24 hours.");
                while (Objects.isNull(telegramResponse.getResult())) {
                    response = telegramAPI.getResponse();
                    telegramResponse = new TelegramResponse(response);
                }
            }

            if (message_id != telegramResponse.getResult().getMessage().getMessage_id()) {

                if (!databaseApi.isUserExists(telegramResponse.getResult().getMessage().getChat().getId())) {        //TODO ?????????????????? ???????????????????? SQLEXCEPTION, ???????????????????? ?? ???? ???????????????? ????????????, ?? ???? null
                    databaseApi.createUser(telegramResponse.getResult().getMessage().getChat().getId(), null, null, telegramResponse.getResult().getMessage().getChat().getUsername());
                }

                databaseApi.saveMessage(telegramResponse.getResult().getMessage().getChat().getId(), telegramResponse.getResult().getMessage().getDate(), telegramResponse.getResult().getMessage().getText());

                message_id = telegramResponse.getResult().getMessage().getMessage_id();
                telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), phraseGenerator.Greetings() + "\n");

                if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("????????????")) {

                    OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI(configReader.getOpen_weather_map_api_key());
                    OpenWeatherMapResponse openWeatherMapResponse = new OpenWeatherMapResponse(openWeatherMapAPI.getWeatherInfo());
//                    TODO: ???????????????????? ?????????????????????? ???? ??????????????

                    String message = "\uD83C\uDF06 ??????????: " + "????????????" + "\n" +
                            "\uD83C\uDF21 ??????????????????????: " + String.format("%.2f", (openWeatherMapResponse.getMain().getTemp() - 273.15)) + " ??C" + "\n" +
                            "\uD83C\uDF21 ?????????????????????? ??????: " + String.format("%.2f", (openWeatherMapResponse.getMain().getFeels_like()) - 273.15) + " ??C" + "\n" +
                            "????????????????: " + openWeatherMapResponse.getMain().getPressure() + " ??????" + "\n" +
                            "\uD83D\uDCA8 ???????????????? ??????????: " + openWeatherMapResponse.getWind().getSpeed() + " ??/??" + "\n" +
                            "\uD83D\uDCA6 ??????????????????: " + openWeatherMapResponse.getMain().getHumidity() + " %" + "\n";

                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), message);

                } else if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("??????????????????")) {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(),
                            "?????????? ?????????????? ?? ????????????????????!");
                } else if (telegramResponse.getResult().getMessage().getText().equalsIgnoreCase("/start")) {
                    String message = "?? ??????. ?????? ???????????? - ???????????????? ???????? ?????????????? ????????????. ?????????? ???? ???????????? \"????????????\"";
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(), message);
                } else {
                    telegramAPI.sendMessage(telegramResponse.getResult().getMessage().getChat().getId(),
                            "\uD83D\uDE11 ?? ???????? ???? ??????????????...");
                }
            }
            Thread.sleep(100);
        } while (true);
    }
}