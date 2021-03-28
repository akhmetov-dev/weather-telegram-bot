import java.util.HashMap;
import java.util.Map;

public class RequestParamBuilder {
    HashMap<String, String> requestParams;
    public RequestParamBuilder() {
        requestParams = new HashMap<String, String>();
    }

    public RequestParamBuilder addParam(String key, String value) {
        requestParams.put(key, value);
        return this;
    }

    public RequestParamBuilder removeParam(String key) {
        requestParams.remove(key);
        return this;
    }

    public String getParamsAsString() {
        StringBuilder parambuilder = new StringBuilder();
        parambuilder.append("?");
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            parambuilder.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        parambuilder.deleteCharAt(parambuilder.length() - 1);
        return parambuilder.toString();
    }

    public void printParams() {
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
