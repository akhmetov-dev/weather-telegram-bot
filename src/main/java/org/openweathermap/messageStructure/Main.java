package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Main {
    float temp;
    float feels_like;
    float temp_min;
    float temp_max;
    int pressure;
    int humidity;

    public Main(JSONObject main) {
        temp = main.getFloat("temp");
        feels_like = main.getFloat("feels_like");
        temp_min = main.getFloat("temp_min");
        temp_max = main.getFloat("temp_max");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

    }
}
