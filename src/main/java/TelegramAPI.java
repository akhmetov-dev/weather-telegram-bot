import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TelegramAPI {
    String bot_token;
    URL url;
    String method_name;
    String get_params;

    public TelegramAPI(String bot_token)  throws IOException {
        this.bot_token = bot_token;
        method_name = "getUpdates";
        url = new URL("https://api.telegram.org/bot" + bot_token + "/" + method_name);
    }

    public String getResponse()  throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset", -1);

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
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

    public void sendMessage(int chat_id, String text) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String url = "https://api.telegram.org/bot" + bot_token + "/" + "sendMessage";

        jsonObject.put("chat_id", chat_id).put("text", text)
                .put("resize_keyboard", true).put("one_time_keyboard", true)
                .put("reply_markup", new JSONObject().put("keyboard", new JSONArray()
                        .put(new JSONArray().put("Погода").put("Настройки"))));

        System.out.println(jsonObject);

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
    }
}