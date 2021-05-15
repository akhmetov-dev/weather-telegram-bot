package org.openweathermap.messageStructure;

import org.json.JSONObject;

/**
 * Объект, содержащий данные о ветре
 */
public class Wind {
    /**
     * Скорость ветра, м/с
     */
    private int speed;

    public Wind(JSONObject wind) {
        speed = wind.getInt("speed");
    }

    public int getSpeed() {
        return speed;
    }
}
