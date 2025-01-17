package com.independentActions;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Task6 {
    @Test
    public static void getTranslations() {
        Response res = given().log().all().auth().basic("", "").get("https://restcountries.com/v3.1/name/India");
        List<Map<String, Object>> respArray = res.jsonPath().getList("$");
        Map<String, Object> transalations = (Map<String, Object>) respArray.get(0).get("translations");
        Map<String,Object> ara = (Map<String,Object>)transalations.get("ara");
        Object official = ara.get("official");
        System.out.println(official);
    }
}
