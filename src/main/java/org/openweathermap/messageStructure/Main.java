package org.openweathermap.messageStructure;

import org.json.JSONObject;

/**
 * Класс, содержащий самые важные погодные характеристики (температура, давление, влажность)
 */
public class Main {
    /**
     * Текущая температура
     */
    private float temp;
    /**
     * Температура, в которой учитывается реальная температура и скорость ветра
     */
    private float feels_like;
    /**
     * Давление, МПа
     */
    private int pressure;
    /**
     * Влажность, %
     */
    private int humidity;

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
