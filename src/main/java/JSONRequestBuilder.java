import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONRequestBuilder {
/*//    HashMap<String, String> requestParams;
    *//*public JSONRequestBuilder() {
        requestParams = new HashMap<String, String>();
    }

    public JSONRequestBuilder addParam(String key, String value) {
        requestParams.put(key, value);
        return this;
    }

    public JSONRequestBuilder removeParam(String key) {
        requestParams.remove(key);
        return this;
    }

    public String toString() {
        StringBuilder parambuilder = new StringBuilder();
        parambuilder.append("{\n");

        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            parambuilder.append("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"" + ",\n");
        }

        parambuilder.deleteCharAt(parambuilder.length() - 2);
        parambuilder.append("}\n");
        return parambuilder.toString();
    }

    public void printParams() {
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }*//*
    JSONObject requestParams;

    public JSONRequestBuilder() {
        requestParams = new JSONObject();
    }

    public JSONRequestBuilder addParam() {

    }*/
}
