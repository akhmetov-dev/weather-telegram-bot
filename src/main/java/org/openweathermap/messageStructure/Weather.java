package org.openweathermap.messageStructure;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
    int id;
    String main;
    String description;
    String icon;

    public Weather(JSONArray weather) {
        id = weather.getJSONObject(0).getInt("id");
        main = weather.getJSONObject(0).getString("main");
        description = weather.getJSONObject(0).getString("description");
        icon = weather.getJSONObject(0).getString("icon");
    }
}