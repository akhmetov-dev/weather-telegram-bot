
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class JSONRequestBuilderTest {

    @Test
    public void addParam() {
        /*JSONRequestBuilder JSONRequestBuilder = new JSONRequestBuilder();
        JSONRequestBuilder.addParam("key1", "value1");
        JSONRequestBuilder.addParam("key2", "value2");
        JSONRequestBuilder.addParam("key3", "value3");
        JSONRequestBuilder.addParam("key4", "value4");

        assertEquals("value1", JSONRequestBuilder.requestParams.get("key1"));
        assertEquals("value2", JSONRequestBuilder.requestParams.get("key2"));
        assertEquals("value3", JSONRequestBuilder.requestParams.get("key3"));
        assertEquals("value4", JSONRequestBuilder.requestParams.get("key4"));*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("chat_id", 216082031).put("text", "Hello world!")
                .put("resize_keyboard", true).put("one_time_keyboard", true)
                .put("reply_markup", new JSONObject().put("keyboard", new JSONArray().put(new JSONArray().put("Button 1").put("Button 3")).put(new JSONArray().put("Button 2").put("Button 4"))));
        System.out.println(jsonObject.toString());
    }

    @Test
    public void removeParam() {
        /*JSONRequestBuilder JSONRequestBuilder = new JSONRequestBuilder();
        JSONRequestBuilder.addParam("key1", "value1");
        JSONRequestBuilder.addParam("key2", "value2");
        assertEquals(2, JSONRequestBuilder.requestParams.size());
        JSONRequestBuilder.removeParam("key2");
        assertEquals(1, JSONRequestBuilder.requestParams.size());*/
    }

    @Test
    public void getParams() {
        /*JSONRequestBuilder JSONRequestBuilder = new JSONRequestBuilder();
        JSONRequestBuilder.addParam("key1", "value1");
        JSONRequestBuilder.addParam("key2", "value2");
        JSONRequestBuilder.addParam("key3", "value3");
        JSONRequestBuilder.addParam("key4", "value4");

        assertEquals("{\n" +
                "\"key1\":\"value1\",\n" +
                "\"key2\":\"value2\",\n" +
                "\"key3\":\"value3\",\n" +
                "\"key4\":\"value4\"\n" +
                "}\n", JSONRequestBuilder.toString());*/
    }
}