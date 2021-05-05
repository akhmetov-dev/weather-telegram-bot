package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Clouds {
    int all;

    public Clouds(JSONObject clouds) {
        all = clouds.getInt("all");
    }
}
