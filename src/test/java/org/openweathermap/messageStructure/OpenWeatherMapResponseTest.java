package org.openweathermap.messageStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpenWeatherMapResponseTest {
    String weather = "{\n" +
            "  \"coord\": {\n" +
            "    \"lon\": 37.6156,\n" +
            "    \"lat\": 55.7522\n" +
            "  },\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 801,\n" +
            "      \"main\": \"Clouds\",\n" +
            "      \"description\": \"few clouds\",\n" +
            "      \"icon\": \"02d\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 280.36,\n" +
            "    \"feels_like\": 276.5,\n" +
            "    \"temp_min\": 279.15,\n" +
            "    \"temp_max\": 281.15,\n" +
            "    \"pressure\": 1005,\n" +
            "    \"humidity\": 65\n" +
            "  },\n" +
            "  \"visibility\": 10000,\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 7,\n" +
            "    \"deg\": 260,\n" +
            "    \"gust\": 13\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 20\n" +
            "  },\n" +
            "  \"dt\": 1620194207,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 1,\n" +
            "    \"id\": 9027,\n" +
            "    \"country\": \"RU\",\n" +
            "    \"sunrise\": 1620178663,\n" +
            "    \"sunset\": 1620234880\n" +
            "  },\n" +
            "  \"timezone\": 10800,\n" +
            "  \"id\": 524901,\n" +
            "  \"name\": \"Moscow\",\n" +
            "  \"cod\": 200\n" +
            "}";

    OpenWeatherMapResponse owmr = new OpenWeatherMapResponse(weather);

    @Test
    public void coordTest() {
        assertEquals(37.6156, owmr.coord.lon, 0.1);
        assertEquals(55.7522, owmr.coord.lat, 0.1);
    }

    @Test
    public void weatherTest() {
        assertEquals(801, owmr.weather.id);
        assertEquals("Clouds", owmr.weather.main);
        assertEquals("few clouds", owmr.weather.description);
        assertEquals("02d", owmr.weather.icon);
            }

    @Test
    public void mainTest() {
        assertEquals(280.36, owmr.main.temp, 0.1);
        assertEquals(276.5, owmr.main.feels_like, 0.1);
        assertEquals(279.15, owmr.main.temp_min, 0.1);
        assertEquals(281.15, owmr.main.temp_max, 0.1);
        assertEquals(1005, owmr.main.pressure, 0.1);
        assertEquals(65, owmr.main.humidity, 0.1);
    }

    @Test
    public void windTest() {
        assertEquals(7, owmr.wind.speed);
        assertEquals(260, owmr.wind.deg);
        assertEquals(13, owmr.wind.gust);
    }

    @Test
    public void cloudsTest() {
        assertEquals(20, owmr.clouds.all);
    }

    @Test
    public void sysTest() {
        assertEquals(1, owmr.sys.type);
        assertEquals(9027, owmr.sys.id);
        assertEquals("RU", owmr.sys.country);
        assertEquals(1620178663, owmr.sys.sunrise);
        assertEquals(1620234880, owmr.sys.sunset);
    }

    @Test
    public void owmrTest() {
        assertEquals("stations", owmr.base);
        assertEquals(10000, owmr.visibility);
        assertEquals(1620194207, owmr.dt);
        assertEquals(10800, owmr.timezone);
        assertEquals(524901, owmr.id);
        assertEquals("Moscow", owmr.name);
        assertEquals(200, owmr.cod);
    }
}