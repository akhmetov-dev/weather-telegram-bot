import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigReaderTest {
    @Test
    public void configReaderTest() throws IOException {
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

        assertEquals("qwerty1", configReader.getBot_token());
        assertEquals("uiop2", configReader.getOpen_weather_map_api_key());
        assertEquals("jdbc:postgresql://localhost:5432/postgres", configReader.getPostgres_url());
        assertEquals("postgres", configReader.getPostgres_user());
        assertEquals("asdfg3", configReader.getPostgres_pass());
    }

}