import org.json.JSONObject;

public class Chat {
    int id;
    String first_name;
    String last_name;
    String username;
    String type;

    public Chat(JSONObject jsonObject) {
        id = jsonObject.getInt("id");
        try {
            first_name = jsonObject.getString("first_name");
        } catch (org.json.JSONException exception) {
            first_name = "";
        }
        try {
            last_name = jsonObject.getString("last_name");
        } catch (org.json.JSONException exception) {
            last_name = "";
        }
        try {
            username = jsonObject.getString("username");
        } catch (org.json.JSONException exception) {
            username = "";
        }
        type = jsonObject.getString("type");
    }
}
