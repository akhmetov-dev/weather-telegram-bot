import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigReaderTest {
    @Test
    public void configReaderTest() {
        String jsonRequest = "{\n" +
                "  \"bot_token\": \"123:qwertyuiop\",\n" +
                "  \"open_weather_map_api_key\": \"asdfghjkl123\"\n" +
                "}";
        ConfigReader configReader = new ConfigReader(jsonRequest);

        assertEquals("123:qwertyuiop", configReader.bot_token);
        assertEquals("asdfghjkl123", configReader.open_weather_map_api_key);
    }

}