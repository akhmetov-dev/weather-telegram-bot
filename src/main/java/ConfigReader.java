import org.json.JSONObject;

public class ConfigReader {
    String bot_token;
    String open_weather_map_api_key;

    public ConfigReader(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            bot_token = jsonObject.getString("bot_token");
            open_weather_map_api_key = jsonObject.getString("open_weather_map_api_key");
        } catch (org.json.JSONException exception) {
            System.out.println("FATAL: Congig JSON string is invalid");
            System.exit(0);
        }
    }
}
