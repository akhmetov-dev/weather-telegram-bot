package org.telegram.messageStructure;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class TelegramResponseTest {

    String json = "{\"ok\":true,\"result\":[{\"update_id\":143683298,\n\"message\":{\"message_id\":575,\"from\":{\"id\":216082031,\"is_bot\":false,\"first_name\":\"\\ud83e\\uddae \\u041d\\u0438\\u043a\\u0438\\u0442\\u0430\",\"last_name\":\"\\u0410\\u0445\\u043c\\u0435\\u0442\\u043e\\u0432 \\ud83e\\uddae\",\"username\":\"ahmetoff\",\"language_code\":\"ru\"},\"chat\":{\"id\":216082031,\"first_name\":\"\\ud83e\\uddae \\u041d\\u0438\\u043a\\u0438\\u0442\\u0430\",\"last_name\":\"\\u0410\\u0445\\u043c\\u0435\\u0442\\u043e\\u0432 \\ud83e\\uddae\",\"username\":\"ahmetoff\",\"type\":\"private\"},\"date\":1620562716,\"text\":\"\\u041f\\u043e\\u0433\\u043e\\u0434\\u0430\"}}]}";

    @Test
    public void telegramResponseTest() {
        TelegramResponse telegramResponse = new TelegramResponse(json);

        assertEquals(true, telegramResponse.getOk());
        assertEquals(575, telegramResponse.getResult().getMessage().getMessage_id());
        assertEquals(1620562716, telegramResponse.getResult().getMessage().getDate());
        assertEquals("Погода", telegramResponse.getResult().getMessage().getText());
        assertEquals(216082031, telegramResponse.getResult().getMessage().getFrom().getId());
        assertEquals("ahmetoff", telegramResponse.getResult().getMessage().getFrom().getUsername());
        assertEquals(216082031, telegramResponse.getResult().getMessage().getChat().getId());
        assertEquals("ahmetoff", telegramResponse.getResult().getMessage().getChat().getUsername());
        assertEquals("private", telegramResponse.getResult().getMessage().getChat().getType());
    }
}