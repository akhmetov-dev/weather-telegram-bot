import org.json.JSONObject;

public class ConfigReader {

    private String bot_token;
    private String open_weather_map_api_key;

    public ConfigReader(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            bot_token = jsonObject.getString("bot_token");
            open_weather_map_api_key = jsonObject.getString("open_weather_map_api_key");
        } catch (org.json.JSONException exception) {
            System.out.println("FATAL: Config JSON string is invalid");
            System.exit(0);
        }
    }

    public String getBot_token() {
        return bot_token;
    }

    public String getOpen_weather_map_api_key() {
        return open_weather_map_api_key;
    }
}
