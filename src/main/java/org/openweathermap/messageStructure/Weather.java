package org.openweathermap.messageStructure;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Класс, содержащий общие характеристики погоды (дождь, снег и т. д) и краткое описание
 */
public class Weather {
    /**
     * Общие характеристики погоды (дождь, снег и т. д)
     */
    private String main;
    /**
     * Краткое описание погоды
     */
    private String description;

    public Weather(JSONArray weather) {
        main = weather.getJSONObject(0).getString("main");
        description = weather.getJSONObject(0).getString("description");
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }
}