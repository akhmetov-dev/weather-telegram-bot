package org.telegram.messageStructure;

import org.json.JSONObject;

public class Message {
    int message_id;
    From from;
    Chat chat;
    int date;
    String text;

    public Message(JSONObject jsonObject) {

        try {
            message_id = jsonObject.getInt("message_id");
        } catch (org.json.JSONException exception) {
            message_id = 0;
        }
        from = new From(jsonObject.getJSONObject("from"));
        chat = new Chat(jsonObject.getJSONObject("chat"));
        try {
            date = jsonObject.getInt("date");
        } catch (org.json.JSONException exception) {
            date = 0;
        }
        try {
            text = jsonObject.getString("text");
        } catch (org.json.JSONException exception) {
            text = "Unknown";
        }
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
