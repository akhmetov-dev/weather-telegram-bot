import org.json.JSONArray;

public class Result {
    int update_id;
    Message message;

    public Result(JSONArray jsonArray) {
        try {
            update_id = jsonArray.getJSONObject(0).getInt("update_id");
        } catch (org.json.JSONException exception) {
            update_id = 0;
        }
        message = new Message(jsonArray.getJSONObject(0).getJSONObject("message"));
    }
}
