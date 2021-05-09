package org.telegram.messageStructure;

import org.json.JSONObject;

public class Chat {
    int id;
    String username;
    String type;

    public Chat(JSONObject jsonObject) {

        id = jsonObject.getInt("id");
        username = jsonObject.getString("username");
        type = jsonObject.getString("type");

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }
}
