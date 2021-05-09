package org.openweathermap.messageStructure;

import org.json.*;

public class OpenWeatherMapResponse {
    Weather weather;
    Main main;
    String name;
    Wind wind;

    public OpenWeatherMapResponse(String message) {
        try {
            JSONObject jsonMessage = new JSONObject(message);
            weather = new Weather(jsonMessage.getJSONArray("weather"));
            main = new Main(jsonMessage.getJSONObject("main"));
            name = jsonMessage.getString("name");
            wind = new Wind(jsonMessage.getJSONObject("wind"));
        } catch (JSONException exception) {
            System.out.println("FATAL: openweathermap response json string is invalid");
            System.exit(0);
        }
    }

    public Weather getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Wind getWind() {
        return wind;
    }
}
