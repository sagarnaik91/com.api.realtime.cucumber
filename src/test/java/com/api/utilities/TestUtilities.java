package com.api.utilities;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtilities {

    public static boolean hasKey(String json, String key) {
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.has(key);

    }

    public static String getJsonKeyValue(String json, String key) {
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get(key).toString();
    }

    public static Map<String, String> getJsonKeyValueFromMap(Response res, String key) {
        Map<String, String> mapOfJson = new HashMap<>();
        return mapOfJson = res.jsonPath().getMap(key);
    }

    public static List<Map<String, String>> getJsonKeyValueFromArray(Response res, String key) {
        List<Map<String, String>> listsOfValue = new ArrayList<>();
        listsOfValue = res.jsonPath().getList(key);
        return listsOfValue;
    }
}
