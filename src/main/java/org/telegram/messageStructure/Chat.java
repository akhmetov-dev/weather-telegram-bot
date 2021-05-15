package org.telegram.messageStructure;

import org.json.JSONObject;

/**
 * Класс, представляющий содержимое чата. Похож на From за иключением того, что если бот может вступать в групповые чаты, в одном чате может быть несколько людей
 */
public class Chat {
    /**
     * id чата
     */
    private int id;
    /**
     * Логин отправителя
     */
    private String username;
    /**
     * Тип отправителя (бот/обычный пользователь)
     */
    private String type;

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
