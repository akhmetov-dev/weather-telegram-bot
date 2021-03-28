import org.json.JSONObject;

public class Message {
    int message_id;
    From from;
    Chat chat;
    int date;
    String text;

    public Message(JSONObject jsonObject) {
        message_id = jsonObject.getInt("message_id");
        from = new From(jsonObject.getJSONObject("from"));
        chat = new Chat(jsonObject.getJSONObject("chat"));
        date = jsonObject.getInt("date");
        text = jsonObject.getString("text");
    }
}
