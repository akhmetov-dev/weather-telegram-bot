package org.openweathermap.messageStructure;

import org.json.*;

/**
 * Класс, представляющий структуру JSON-ответа от openweathermap api
 */
public class OpenWeatherMapResponse {
    /**
     * Объект, содержащий общие характеристики погоды (дождь, снег и т. д) и краткое описание
     */
    private Weather weather;
    /**
     * Объект, содержащий самые важные погодные характеристики (температура, давление, влажность)
     */
    private Main main;
    /**
     * Название города
     */
    private String name;
    /**
     * Объект, содержащий данные о ветре
     */
    private Wind wind;

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
