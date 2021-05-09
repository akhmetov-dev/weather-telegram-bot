package org.telegram.API;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TelegramAPITest {
    String responsejson = "{\"ok\":true,\"result\":[{\"update_id\":143683298,\"message\":{\"message_id\":575,\"from\":{\"id\":216082031,\"is_bot\":false,\"first_name\":\"\\ud83e\\uddae \\u041d\\u0438\\u043a\\u0438\\u0442\\u0430\",\"last_name\":\"\\u0410\\u0445\\u043c\\u0435\\u0442\\u043e\\u0432 \\ud83e\\uddae\",\"username\":\"ahmetoff\",\"language_code\":\"ru\"},\"chat\":{\"id\":216082031,\"first_name\":\"\\ud83e\\uddae \\u041d\\u0438\\u043a\\u0438\\u0442\\u0430\",\"last_name\":\"\\u0410\\u0445\\u043c\\u0435\\u0442\\u043e\\u0432 \\ud83e\\uddae\",\"username\":\"ahmetoff\",\"type\":\"private\"},\"date\":1620562716,\"text\":\"\\u041f\\u043e\\u0433\\u043e\\u0434\\u0430\"}}]}";
    String sendJson = "{\"ok\":true,\"result\":{\"message_id\":580,\"from\":{\"id\":1493206094,\"is_bot\":true,\"first_name\":\"WeatherBot\",\"username\":\"ahmetoff_bot\"},\"chat\":{\"id\":216082031,\"first_name\":\"\\ud83e\\uddae \\u041d\\u0438\\u043a\\u0438\\u0442\\u0430\",\"last_name\":\"\\u0410\\u0445\\u043c\\u0435\\u0442\\u043e\\u0432 \\ud83e\\uddae\",\"username\":\"ahmetoff\",\"type\":\"private\"},\"date\":1620566475,\"text\":\"Hello world!\"}}";

    @Test
    public void getResponseTest() {
        TelegramAPI telegramAPI = new TelegramAPI("Here you type your openweathermap key...");
        assertEquals(responsejson, telegramAPI.getResponse());
    }

    @Test
    public void sendMessageTest(){
        TelegramAPI telegramAPI = new TelegramAPI("Here you type your openweathermap key...");
//        assertEquals(sendJson, telegramAPI.sendMessage(216082031, "Hello world!")); поле date
    }
}