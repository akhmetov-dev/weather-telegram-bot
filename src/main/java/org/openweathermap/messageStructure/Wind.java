package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Wind {
    int speed;
    int deg;
    int gust;

    public Wind(JSONObject wind) {
        speed = wind.getInt("speed");
        deg = wind.getInt("deg");
        gust = wind.getInt("gust");
    }
}
