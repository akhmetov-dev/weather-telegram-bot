package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Main {
    float temp;

    float feels_like;
    int pressure;
    int humidity;

    public Main(JSONObject main) {
        temp = main.getFloat("temp");
        feels_like = main.getFloat("feels_like");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

    }

    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
