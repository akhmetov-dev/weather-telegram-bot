import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class TelegramAPI {
    String bot_token;
    URL url;
    String method_name;
    String get_params;

    public TelegramAPI(String bot_token)  throws IOException {
        RequestParamBuilder requestParamBuilder = new RequestParamBuilder();
        this.bot_token = bot_token;
        method_name = "getUpdates";

        url = new URL("https://api.telegram.org/bot" + bot_token + "/" + method_name + requestParamBuilder.addParam("offset", "-1").getParamsAsString());
    }

    public String getResponse()  throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0)" +
                "Gecko/20100101 Firefox/85.0");

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
        RequestParamBuilder requestParamBuilder = new RequestParamBuilder();
        String url = "https://api.telegram.org/bot" + bot_token + "/" + "sendMessage" + requestParamBuilder.addParam("chat_id", String.valueOf(chat_id)).addParam("text", text).getParamsAsString();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0)" +
                "Gecko/20100101 Firefox/85.0");

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