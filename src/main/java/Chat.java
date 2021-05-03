import org.json.JSONObject;

public class Chat {
    int id;
    String first_name;
    String last_name;
    String username;
    String type;

    public Chat(JSONObject jsonObject) {
        try {
            id = jsonObject.getInt("id");
        } catch (org.json.JSONException exception) {
            id = 0;
        }
        try {
            first_name = jsonObject.getString("first_name");
        } catch (org.json.JSONException exception) {
            first_name = "Unknown";
        }
        try {
            last_name = jsonObject.getString("last_name");
        } catch (org.json.JSONException exception) {
            last_name = "Unknown";
        }
        try {
            username = jsonObject.getString("username");
        } catch (org.json.JSONException exception) {
            username = "Unknown";
        }
        try {
            type = jsonObject.getString("type");
        } catch (org.json.JSONException exception) {
            type = "Unknown";
        }
    }
}
