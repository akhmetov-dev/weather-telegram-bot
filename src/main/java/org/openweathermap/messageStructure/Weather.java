package org.openweathermap.messageStructure;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
    private String main;
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