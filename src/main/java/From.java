import org.json.JSONObject;

public class From {
    int id;
    boolean is_bot;
    String first_name;
    String last_name;
    String username;
    String language_code;

    public From(JSONObject jsonObject) {
        try {
            id = jsonObject.getInt("id");
        } catch (org.json.JSONException exception) {
            id = 0;
        }
        try {
            is_bot = jsonObject.getBoolean("is_bot");
        } catch (org.json.JSONException exception) {
            is_bot = false;
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
            language_code = jsonObject.getString("language_code");
        } catch (org.json.JSONException exception) {
            language_code = "Unknown";
        }
    }
}
