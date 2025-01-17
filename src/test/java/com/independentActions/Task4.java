package com.independentActions;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Task4 {
    @Test
    public static void getTimeZone() {
        Response res = given().log().all().auth().basic("", "").get("https://restcountries.com/v3.1/name/India");
        List<Map<String, Object>> respArray = res.jsonPath().getList("$");
        List<Object> timezones = (List<Object>) respArray.get(0).get("timezones");
        System.out.println(timezones.get(0));
    }
}
