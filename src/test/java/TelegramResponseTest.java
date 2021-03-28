import org.junit.Test;

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
        assertEquals(true, telegramResponse.ok);
    }

    @Test
    public void testUpdateId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(143683047, TelegramResponse.result.update_id);
    }

    @Test
    public void testMessageId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(16, TelegramResponse.result.message.message_id);
    }

    @Test
    public void testDate() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(1616854939, TelegramResponse.result.message.date);
    }

    @Test
    public void testText() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u041f\u0440\u0438\u0432\u0435\u0442, \u043c\u0438\u0440!", TelegramResponse.result.message.text);
    }

    @Test
    public void testFromId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(216082031, TelegramResponse.result.message.from.id);
    }

    @Test
    public void testFromIsBot() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(false, TelegramResponse.result.message.from.is_bot);
    }

    @Test
    public void testFromFirstName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\ud83e\uddae \u041d\u0438\u043a\u0438\u0442\u0430", TelegramResponse.result.message.from.first_name);
    }

    @Test
    public void testFromLastName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u0410\u0445\u043c\u0435\u0442\u043e\u0432 \ud83e\uddae", TelegramResponse.result.message.from.last_name);
    }

    @Test
    public void testFromUsername() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ahmetoff", TelegramResponse.result.message.from.username);
    }

    @Test
    public void testFromLanguageCode() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ru", TelegramResponse.result.message.from.language_code);
    }

    @Test
    public void testChatId() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals(216082031, TelegramResponse.result.message.chat.id);
    }

    @Test
    public void testChatFirstName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\ud83e\uddae \u041d\u0438\u043a\u0438\u0442\u0430", TelegramResponse.result.message.chat.first_name);
    }

    @Test
    public void testChatLastName() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("\u0410\u0445\u043c\u0435\u0442\u043e\u0432 \ud83e\uddae", TelegramResponse.result.message.chat.last_name);
    }

    @Test
    public void testChatUsername() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("ahmetoff", TelegramResponse.result.message.chat.username);
    }

    @Test
    public void testChatType() throws Exception {
        readJSONFromFile();
        TelegramResponse TelegramResponse = new TelegramResponse(jsonResponse);
        assertEquals("private", TelegramResponse.result.message.chat.type);
    }
}