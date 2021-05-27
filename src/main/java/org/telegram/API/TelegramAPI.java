package org.telegram.API;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Данный класс - способ взаимодействия приложения с telegram API
 *
 */
public class TelegramAPI {
    /**
     * содержит строчное представления токена для работы с ботом с помощью telegram api
     */
    private String bot_token;
    /**
     * URL-адрес для работы с openweathermap API
     */
    private URL url;
    /**
     * название метода, передаваемого через GET-параметры для работы с telegram api (например, getUpdates)
     */
    private String method_name;

    public TelegramAPI(String bot_token) {

        this.bot_token = bot_token;
        method_name = "getUpdates";
        try {
            url = new URL("https://api.telegram.org/bot" + bot_token + "/" + method_name);
        } catch (MalformedURLException exception) {
            System.out.println("FATAL: Web-service api.telegram.org does not responds");
            System.exit(0);
        }
    }

    /**
     * Запрашивает новые сообщения, которые пользователи отправляли боту
     * ВАЖНО. Пришедшие сообщения хранятся в облаке telegram ровно сутки. После этого все данные удаляются и в ответе поле result будет пустым
     * @return строковое представление полученного JSON-ответа
     */
    public String getResponse() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset", -1);

        HttpsURLConnection httpsURLConnection = null;
        try {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
        } catch (IOException exception) {
            System.out.println("FATAL: Can not open connection");
            System.exit(0);
        }
        try {
            httpsURLConnection.setRequestMethod("POST");
        } catch (ProtocolException exception) {
            System.out.println("FATAL: Something wrong with protocol");
            System.exit(0);
        }
        httpsURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0)" +
                "Gecko/20100101 Firefox/85.0");
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        httpsURLConnection.setDoOutput(true);

        try {
            OutputStream os = httpsURLConnection.getOutputStream();
            byte[] input = jsonObject.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (IOException exception) {
            System.out.println("FATAL: Something wrong with output stream");
            System.exit(0);
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while( ( line = reader.readLine() ) != null )
            {
                stringBuilder.append(line);
            }
            inputStream.close();
            reader.close();
        } catch (IOException exception) {
            System.out.println("FATAL: Something wrong with input stream");
            System.exit(0);
        }
        return stringBuilder.toString();
    }

    /**
     * Делает запрос к telegram api на отправку сообщения определенному пользователю
     * @param chat_id id чата, в который нужно отправить сообщение
     * @param text текст, который нужно отправить определенному пользователю
     * @return строковое представление полученного JSON-ответа
     * @throws IOException
     */
    public String sendMessage(long chat_id, String text) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String url = "https://api.telegram.org/bot" + bot_token + "/" + "sendMessage";
        jsonObject.put("chat_id", chat_id).put("text", text).put("reply_markup", new JSONObject().put("keyboard", new JSONArray()
                .put(new JSONArray().put("Погода").put("Настройки"))).put("resize_keyboard", true));

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0)" +
                "Gecko/20100101 Firefox/85.0");
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        httpsURLConnection.setDoOutput(true);

        try(OutputStream os = httpsURLConnection.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        InputStream inputStream = httpsURLConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while( ( line = reader.readLine() ) != null )
        {
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder.toString();
    }
}