package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Sys {
    int type;
    int id;
    String country;
    int sunrise;
    int sunset;

    public Sys(JSONObject sys) {
        type = sys.getInt("type");
        id = sys.getInt("id");
        country = sys.getString("country");
        sunrise = sys.getInt("sunrise");
        sunset = sys.getInt("sunset");
    }
}
