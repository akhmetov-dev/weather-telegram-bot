package org.telegram.messageStructure;

import org.json.JSONException;
import org.json.JSONObject;

public class TelegramResponse {
    JSONObject jsonObject;
    boolean ok;
    Result result;

    public TelegramResponse(String jsonResponse) {
        try {
            jsonObject = new JSONObject(jsonResponse);
            ok = jsonObject.getBoolean("ok");
            result = new Result(jsonObject.getJSONArray("result"));
        } catch (JSONException exception) {
            System.out.println("FATAL: telegram response json string is invalid");
            System.exit(0);
        }
    }

    public Result getResult() {
        return this.result;
    }

    public boolean getOk() {
        return this.ok;
    }
}
