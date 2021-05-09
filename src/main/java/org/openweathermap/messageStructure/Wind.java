package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Wind {
    public int getSpeed() {
        return speed;
    }

    int speed;

    public Wind(JSONObject wind) {
        speed = wind.getInt("speed");
    }
}
