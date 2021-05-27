package org.telegram.messageStructure;

import org.json.JSONObject;

/**
 * Класс, содержащий данные об отправителе сообщения
 */
public class From {
    /**
     * id отправителя
     */
    private long id;
    /**
     * Логин отправителя
     */
    private String username;

    public From(JSONObject jsonObject) {
        id = jsonObject.getInt("id");
        username = jsonObject.getString("username");
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
