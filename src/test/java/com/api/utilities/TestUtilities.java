package com.api.utilities;

import io.restassured.response.Response;
import org.json.JSONObject;

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

    public static Map<String, String> getMapFromJsonResponse(Response res, String key) {
        Map<String, String> mapOfJson = new HashMap<>();
        return mapOfJson = res.jsonPath().getMap(key);
    }

    public static List<Map<String, Object>> getArrayFromJsonResponse(Response res, String key) {
        List<Map<String, Object>> listsOfValue = new ArrayList<>();
        listsOfValue = res.jsonPath().getList(key);
        return listsOfValue;
    }

    public static Object getValueOfKeyFromArrayOfMap(List<Map<String, Object>> responseBody, String fieldName) {
        return responseBody.get(0).get(fieldName);
    }

    public static Object getKeyValueFromMap(Map<String, String> responseBody, String key) {
        return responseBody.get(key);
    }

    public static int getCountOfObject(Map<String, String> responseMap) {
        return responseMap.size();
    }
}
