package org.telegram.messageStructure;

import org.json.JSONArray;

/**
 * Класс, представляющий тело ответа от telegram api
 */
public class Result {
    /**
     * Класс, представляющий полученное/отправленное сообщение
     */
    private Message message;
    public Result(JSONArray jsonArray) {
        message = new Message(jsonArray.getJSONObject(0).getJSONObject("message"));
    }
    public Message getMessage() {
        return message;
    }
}
