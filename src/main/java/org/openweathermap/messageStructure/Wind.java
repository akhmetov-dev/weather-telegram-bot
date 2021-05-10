package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Wind {
    private int speed;

    public Wind(JSONObject wind) {
        speed = wind.getInt("speed");
    }

    public int getSpeed() {
        return speed;
    }
}
