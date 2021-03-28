import org.junit.Test;

import static org.junit.Assert.*;

public class RequestParamBuilderTest {

    @Test
    public void addParam() {
        RequestParamBuilder requestParamBuilder = new RequestParamBuilder();
        requestParamBuilder.addParam("key1", "value1");
        requestParamBuilder.addParam("key2", "value2");
        requestParamBuilder.addParam("key3", "value3");
        requestParamBuilder.addParam("key4", "value4");

        assertEquals("value1", requestParamBuilder.requestParams.get("key1"));
        assertEquals("value2", requestParamBuilder.requestParams.get("key2"));
        assertEquals("value3", requestParamBuilder.requestParams.get("key3"));
        assertEquals("value4", requestParamBuilder.requestParams.get("key4"));
    }

    @Test
    public void removeParam() {
        RequestParamBuilder requestParamBuilder = new RequestParamBuilder();
        requestParamBuilder.addParam("key1", "value1");
        requestParamBuilder.addParam("key2", "value2");
        assertEquals(2, requestParamBuilder.requestParams.size());
        requestParamBuilder.removeParam("key2");
        assertEquals(1, requestParamBuilder.requestParams.size());
    }

    @Test
    public void getParams() {
        RequestParamBuilder requestParamBuilder = new RequestParamBuilder();
        requestParamBuilder.addParam("key1", "value1");
        requestParamBuilder.addParam("key2", "value2");
        requestParamBuilder.addParam("key3", "value3");
        requestParamBuilder.addParam("key4", "value4");

        assertEquals("?key1=value1&key2=value2&key3=value3&key4=value4", requestParamBuilder.getParamsAsString());
    }
}