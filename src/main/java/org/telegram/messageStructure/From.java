package org.telegram.messageStructure;

import org.json.JSONObject;

public class From {
    private int id;
    private String username;

    public From(JSONObject jsonObject) {
        id = jsonObject.getInt("id");
        username = jsonObject.getString("username");
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
