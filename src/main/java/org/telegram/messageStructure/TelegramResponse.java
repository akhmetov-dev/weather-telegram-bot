package org.telegram.messageStructure;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Класс, представляющий структуру JSON-ответа от telegram api
 */
public class TelegramResponse {
    /**
     * JSON-объект, поля которого парсятся и копируются в TelegramResponse
     */
    private JSONObject jsonObject;
    /**
     * Ответ от сервера telegram api: true, если запрос успешно обработан, false, если что-то пошло не так
     */
    private boolean ok;
    /**
     * Тело ответа от telegram api
     */
    private Result result;

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
