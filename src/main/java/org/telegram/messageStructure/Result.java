package org.telegram.messageStructure;

import org.json.JSONArray;

public class Result {
    Message message;
    public Result(JSONArray jsonArray) {
        message = new Message(jsonArray.getJSONObject(0).getJSONObject("message"));
    }
    public Message getMessage() {
        return message;
    }
}
