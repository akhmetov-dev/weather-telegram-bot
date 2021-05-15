package org.telegram.messageStructure;

import org.json.JSONObject;

/**
 * Класс, представляющий тело ответа от telegram api
 */
public class Message {
    /**
     * Уникальный идентификатор сообщения
     */
    private int message_id;
    /**
     * Объект, содержаний данные об отправителе
     */
    private From from;
    /**
     * Объект, содержаний данные о чате
     */
    private Chat chat;
    /**
     * Отправки/получения сообщения
     */
    private int date;
    /**
     * Содержимое сообщения
     */
    private String text;

    public Message(JSONObject jsonObject) {
        message_id = jsonObject.getInt("message_id");
        from = new From(jsonObject.getJSONObject("from"));
        chat = new Chat(jsonObject.getJSONObject("chat"));
        date = jsonObject.getInt("date");
        text = jsonObject.getString("text");
    }

    public int getMessage_id() {
        return message_id;
    }

    public From getFrom() {
        return this.from;
    }

    public Chat getChat() {
        return this.chat;
    }

    public int getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
