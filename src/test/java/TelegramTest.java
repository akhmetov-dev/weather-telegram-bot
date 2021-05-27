import org.junit.Test;
import org.telegram.API.TelegramAPI;
import org.telegram.messageStructure.TelegramResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class TelegramTest {

    @Test
    public void telegramResponseTest() throws IOException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/test/java/TelegramResponseSampleData.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File TelegramResponseSampleData.json could not be read");

            System.exit(0);
        }
        TelegramResponse telegramResponse = new TelegramResponse(configString);
        assertTrue(telegramResponse.getOk());
        assertEquals(575, telegramResponse.getResult().getMessage().getMessage_id());
        assertEquals(1620562716, telegramResponse.getResult().getMessage().getDate());
        assertEquals("Погода", telegramResponse.getResult().getMessage().getText());
        assertEquals(216082031, telegramResponse.getResult().getMessage().getFrom().getId());
        assertEquals("ahmetoff", telegramResponse.getResult().getMessage().getFrom().getUsername());
        assertEquals(216082031, telegramResponse.getResult().getMessage().getChat().getId());
        assertEquals("ahmetoff", telegramResponse.getResult().getMessage().getChat().getUsername());
        assertEquals("private", telegramResponse.getResult().getMessage().getChat().getType());
    }

    @Test
    public void telegramApiTest() throws IOException {
        String stringTelegramResponseFromJson = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/test/java/TelegramResponseSampleData.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            stringTelegramResponseFromJson = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File TelegramResponseSampleData.json could not be read");

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

        TelegramAPI telegramAPI = new TelegramAPI(configReader.getBot_token());

        String  stringTelegramResponse = telegramAPI.getResponse();

        assertEquals(stringTelegramResponse, stringTelegramResponseFromJson);
    }
}