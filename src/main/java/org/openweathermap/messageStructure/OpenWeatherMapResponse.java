package org.openweathermap.messageStructure;

import org.json.JSONObject;

public class OpenWeatherMapResponse {
    Coord coord;
    Weather weather;
    String base;
    Main main;
    int visibility;
    Wind wind;
    Clouds clouds;
    int dt;
    Sys sys;
    int timezone;
    int id;
    String name;
    int cod;

    public OpenWeatherMapResponse (String message) {
        JSONObject jsonMessage = new JSONObject(message);

        coord = new Coord(jsonMessage.getJSONObject("coord"));
        weather = new Weather(jsonMessage.getJSONArray("weather"));
        base = jsonMessage.getString("base");
        main = new Main(jsonMessage.getJSONObject("main"));
        visibility = jsonMessage.getInt("visibility");
        wind = new Wind(jsonMessage.getJSONObject("wind"));
        clouds = new Clouds(jsonMessage.getJSONObject("clouds"));
        dt = jsonMessage.getInt("dt");
        sys = new Sys(jsonMessage.getJSONObject("sys"));
        timezone = jsonMessage.getInt("timezone");
        id = jsonMessage.getInt("id");
        name = jsonMessage.getString("name");
        cod = jsonMessage.getInt("cod");


    }
}
