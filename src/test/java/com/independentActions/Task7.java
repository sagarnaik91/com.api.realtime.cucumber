package com.independentActions;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Task7 {
    @Test
    public static void getTranslations() {
        Response res = given().log().all().auth().basic("", "").get("https://restcountries.com/v3.1/name/India");
        List<Map<String, Object>> respArray = res.jsonPath().getList("$");
        Map<String, Object> translations = (Map<String, Object>) respArray.get(0).get("translations");
        Map<String, Object> bre = (Map<String, Object>) translations.get("bre");
        Assert.assertEquals(bre.get("official"), "Republik India");

    }
}
