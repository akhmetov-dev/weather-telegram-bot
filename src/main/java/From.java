import org.json.JSONObject;

public class From {
    int id;
    boolean is_bot;
    String first_name;
    String last_name;
    String username;
    String language_code;

    public From(JSONObject jsonObject) {
        id = jsonObject.getInt("id");
        is_bot = jsonObject.getBoolean("is_bot");
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
        language_code = jsonObject.getString("language_code");
    }
}
