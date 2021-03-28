import org.json.JSONObject;

public class TelegramResponse {
    JSONObject jsonObject;
    boolean ok;
    Result result;

    public TelegramResponse(String jsonResponse) {
        jsonObject = new JSONObject(jsonResponse);
        ok = jsonObject.getBoolean("ok");
        result = new Result(jsonObject.getJSONArray("result"));
    }
}
