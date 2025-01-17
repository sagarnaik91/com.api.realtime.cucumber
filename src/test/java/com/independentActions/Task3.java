package com.independentActions;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Task3 {
    @Test
    public static void getCarSigns() {
        Response res = given().auth().basic("", "").log().all().get("https://restcountries.com/v3.1/name/India");
        List<Map<String, Object>> responseArray = res.jsonPath().getList("$");
        Map<String,Object> carSigns= (Map<String, Object>) responseArray.get(0).get("car");
        List<Object> signs=(List<Object>) carSigns.get("signs");
        System.out.println(signs.get(0));


    }
}
