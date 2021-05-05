package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class Coord {
    float lon;
    float lat;

    public Coord(JSONObject coord) {
        lon = coord.getFloat("lon");
        lat = coord.getFloat("lat");
    }
}
