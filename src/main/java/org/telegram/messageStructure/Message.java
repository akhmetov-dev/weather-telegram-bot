package org.telegram.messageStructure;

import org.json.JSONObject;

public class Message {
    int message_id;
    From from;
    Chat chat;
    int date;
    String text;

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
