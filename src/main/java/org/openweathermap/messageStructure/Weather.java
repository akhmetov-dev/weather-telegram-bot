package org.openweathermap.messageStructure;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    String main;
    String description;

    public Weather(JSONArray weather) {
        main = weather.getJSONObject(0).getString("main");
        description = weather.getJSONObject(0).getString("description");
    }
}