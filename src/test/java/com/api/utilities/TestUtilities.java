package com.api.utilities;

import io.restassured.response.Response;
import org.json.JSONObject;

public class TestUtilities {

    public static boolean hasKey(String json, String key) {
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.has(key);

    }

    public static String getJsonKeyValue(String json, String key) {
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get(key).toString();
    }

    public static String getJsonKeyValueFromMap(Response res, String key)
    {
       return res.jsonPath().getString(key);
    }
}
