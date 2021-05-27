import org.json.JSONObject;

public class ConfigReader {

    private String bot_token;
    private String open_weather_map_api_key;
    private String postgres_url;
    private String postgres_user;
    private String postgres_pass;

    public ConfigReader(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            bot_token = jsonObject.getString("bot_token");
            open_weather_map_api_key = jsonObject.getString("open_weather_map_api_key");
            postgres_url = jsonObject.getString("postgres_url");
            postgres_user = jsonObject.getString("postgres_user");
            postgres_pass = jsonObject.getString("postgres_pass");
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

    public String getPostgres_url() {
        return postgres_url;
    }

    public String getPostgres_user() {
        return postgres_user;
    }

    public String getPostgres_pass() {
        return postgres_pass;
    }
}
