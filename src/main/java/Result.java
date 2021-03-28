import org.json.JSONArray;

public class Result {
    int update_id;
    Message message;

    public Result(JSONArray jsonArray) {
        update_id = jsonArray.getJSONObject(0).getInt("update_id");
        message = new Message(jsonArray.getJSONObject(0).getJSONObject("message"));
    }
}
