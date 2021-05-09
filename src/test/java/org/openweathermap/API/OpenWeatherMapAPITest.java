package org.openweathermap.API;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OpenWeatherMapAPITest {
    //Перед запуском теста получить JSON-строку через браузер и вставить в переменную json
    String json = "{\"coord\":{\"lon\":37.6156,\"lat\":55.7522},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"base\":\"stations\",\"main\":{\"temp\":281.79,\"feels_like\":279.04,\"temp_min\":281.15,\"temp_max\":282.15,\"pressure\":1014,\"humidity\":53},\"visibility\":10000,\"wind\":{\"speed\":5,\"deg\":330,\"gust\":10},\"rain\":{\"1h\":0.77},\"clouds\":{\"all\":20},\"dt\":1620565414,\"sys\":{\"type\":1,\"id\":9027,\"country\":\"RU\",\"sunrise\":1620523767,\"sunset\":1620580952},\"timezone\":10800,\"id\":524901,\"name\":\"Moscow\",\"cod\":200}";

    @Test
    public void getWeatherInfoTest() throws IOException {
        OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI("Here you type your openweathermap key...");
        assertEquals(json, openWeatherMapAPI.getWeatherInfo());
    }
}