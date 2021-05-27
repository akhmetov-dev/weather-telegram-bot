import org.junit.Test;
import org.openweathermap.API.OpenWeatherMapAPI;
import org.openweathermap.messageStructure.OpenWeatherMapResponse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class OpenWeatherMapResponseTest {

    @Test
    public void openWeatherMapResponseTest() throws IOException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/test/java/OpenWeatherMapResponseSampleData.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File OpenWeatherMapResponseSampleData.json could not be read");

            System.exit(0);
        }
        OpenWeatherMapResponse openWeatherMapResponse = new OpenWeatherMapResponse(configString);
        assertEquals(openWeatherMapResponse.getName(), "Moscow");
        assertEquals(openWeatherMapResponse.getWeather().getMain(), "Clouds");
        assertEquals(openWeatherMapResponse.getWeather().getDescription(), "scattered clouds");
        assertEquals(openWeatherMapResponse.getMain().getTemp(), 291.05, 5);
        assertEquals(openWeatherMapResponse.getMain().getFeels_like(), 291.27, 5);
        assertEquals(openWeatherMapResponse.getMain().getPressure(), 1015);
        assertEquals(openWeatherMapResponse.getMain().getHumidity(), 91);
        assertEquals(openWeatherMapResponse.getWind().getSpeed(), 1.12, 0.2);
    }

    @Test
    public void openWearherMapApiTest() throws IOException {
        String stringOpenWeatherMapResponseFromJson = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/test/java/OpenWeatherMapResponseSampleData.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            stringOpenWeatherMapResponseFromJson = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File OpenWeatherMapResponseSampleData.json could not be read");

            System.exit(0);
        }

        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File config.json could not be read");
            System.exit(0);
        }

        ConfigReader configReader = new ConfigReader(configString);
        OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI(configReader.getOpen_weather_map_api_key());

        String  stringOpenWeatherMapResponse = openWeatherMapAPI.getWeatherInfo();

        assertEquals(stringOpenWeatherMapResponse, stringOpenWeatherMapResponseFromJson);
    }
}