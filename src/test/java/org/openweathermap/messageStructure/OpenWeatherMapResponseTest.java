package org.openweathermap.messageStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpenWeatherMapResponseTest {
    String json = "{\"coord\":{\"lon\":37.6156,\"lat\":55.7522},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"base\":\"stations\",\"main\":{\"temp\":281.79,\"feels_like\":279.04,\"temp_min\":281.15,\"temp_max\":282.15,\"pressure\":1014,\"humidity\":53},\"visibility\":10000,\"wind\":{\"speed\":5,\"deg\":330,\"gust\":10},\"rain\":{\"1h\":1},\"clouds\":{\"all\":20},\"dt\":1620564523,\"sys\":{\"type\":1,\"id\":9027,\"country\":\"RU\",\"sunrise\":1620523767,\"sunset\":1620580952},\"timezone\":10800,\"id\":524901,\"name\":\"Moscow\",\"cod\":200}";

    @Test
    public void openWeatherMapResponseTest() {
        OpenWeatherMapResponse openWeatherMapResponse = new OpenWeatherMapResponse(json);

        assertEquals(openWeatherMapResponse.getName(), "Moscow");
        assertEquals(openWeatherMapResponse.getWeather().getMain(), "Rain");
        assertEquals(openWeatherMapResponse.getWeather().getDescription(), "light rain");
        assertEquals(openWeatherMapResponse.getMain().getTemp(), 281.79, 5);
        assertEquals(openWeatherMapResponse.getMain().getFeels_like(), 279.04, 5);
        assertEquals(openWeatherMapResponse.getMain().getPressure(), 1014);
        assertEquals(openWeatherMapResponse.getMain().getHumidity(), 53);
        assertEquals(openWeatherMapResponse.getWind().getSpeed(), 5);
    }

}