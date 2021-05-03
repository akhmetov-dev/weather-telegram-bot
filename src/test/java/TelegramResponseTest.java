import org.junit.Test;
import org.telegram.messageStructure.TelegramResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

public class TelegramResponseTest {
    String jsonResponse;

    public void readJSONFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Sample.json")));
        String line;
        StringBuilder jsonResponse = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            jsonResponse.append(line);
        }
        this.jsonResponse = jsonResponse.toString();
        bufferedReader.close();
    }

    @Test
    public void testOk() throws Exception {
        readJSONFromFile();
        System.out.println(jsonResponse.toString());

        TelegramResponse telegramResponse = new TelegramResponse(jsonResponse.toString());
        assertEquals(true, telegramResponse.getOk());
    }

    @Test
    public void testUpdateId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(143683047, TelegramResponse.getResult().getUpdate_id());
    }

    @Test
    public void testMessageId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(16, TelegramResponse.getResult().getMessage().getMessage_id());
    }

    @Test
    public void testDate() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(1616854939, TelegramResponse.getResult().getMessage().getDate());
    }

    @Test
    public void testText() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u041f\u0440\u0438\u0432\u0435\u0442, \u043c\u0438\u0440!", TelegramResponse.getResult().getMessage().getText());
    }

    @Test
    public void testFromId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(216082031, TelegramResponse.getResult().getMessage().getFrom().getId());
    }

    @Test
    public void testFromIsBot() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(false, TelegramResponse.getResult().getMessage().getFrom().getIsBot());
    }

    @Test
    public void testFromFirstName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\ud83e\uddae \u041d\u0438\u043a\u0438\u0442\u0430", TelegramResponse.getResult().getMessage().getFrom().getFirst_name());
    }

    @Test
    public void testFromLastName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u0410\u0445\u043c\u0435\u0442\u043e\u0432 \ud83e\uddae", TelegramResponse.getResult().getMessage().getFrom().getLast_name());
    }

    @Test
    public void testFromUsername() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ahmetoff", TelegramResponse.getResult().getMessage().getFrom().getUsername());
    }

    @Test
    public void testFromLanguageCode() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ru", TelegramResponse.getResult().getMessage().getFrom().getLanguage_code());
    }

    @Test
    public void testChatId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(216082031, TelegramResponse.getResult().getMessage().getChat().getId());
    }

    @Test
    public void testChatFirstName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\ud83e\uddae \u041d\u0438\u043a\u0438\u0442\u0430", TelegramResponse.getResult().getMessage().getChat().getFirst_name());
    }

    @Test
    public void testChatLastName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u0410\u0445\u043c\u0435\u0442\u043e\u0432 \ud83e\uddae", TelegramResponse.getResult().getMessage().getChat().getLast_name());
    }

    @Test
    public void testChatUsername() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ahmetoff", TelegramResponse.getResult().getMessage().getChat().getUsername());
    }

    @Test
    public void testChatType() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("private", TelegramResponse.getResult().getMessage().getChat().getType());
    }
}