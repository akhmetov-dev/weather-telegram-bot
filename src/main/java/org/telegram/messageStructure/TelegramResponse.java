package org.telegram.messageStructure;

import org.json.JSONObject;

public class TelegramResponse {
    JSONObject jsonObject;
    boolean ok;
    Result result;

    public TelegramResponse(String jsonResponse) {
        try {
            jsonObject = new JSONObject(jsonResponse);
        } catch (org.json.JSONException exception) {
            System.out.println("Bad json error");
        }
        try {
            ok = jsonObject.getBoolean("ok");
        } catch (org.json.JSONException exception) {
            ok = false;
        }
        try {
            result = new Result(jsonObject.getJSONArray("result"));
        } catch (org.json.JSONException exception) {
            System.out.println("There is no result field in response.");
        }
    }

    public Result getResult() {
        return  this.result;
    }

    public boolean getOk() {
        return this.ok;
    }
}
