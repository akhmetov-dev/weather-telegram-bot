package org.openweathermap.API;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenWeatherMapAPI {
    String open_weather_map_api_key;
    URL url;

    public OpenWeatherMapAPI(String open_weather_map_api_key) {
        this.open_weather_map_api_key = open_weather_map_api_key;
        try {
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=" + this.open_weather_map_api_key);
        } catch (MalformedURLException exception) {
            System.out.println("FATAL: Web-service api.openweathermap.org does not responds");
            System.exit(0);
        }
    }

    public String getWeatherInfo() throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:85.0)" +
                "Gecko/20100101 Firefox/85.0");
        httpsURLConnection.setRequestProperty("Content-Type", "text/html; utf-8");
        httpsURLConnection.setRequestProperty("Accept", "application/json");

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
