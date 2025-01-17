package com.independentActions;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Task5 {
    @Test
    public static void getFlags() {
        Response res = given().log().all().auth().basic("", "").get("https://restcountries.com/v3.1/name/India");
        List<Map<String,Object>> respArray = res.jsonPath().getList("$");
        Map<String,Object> respMap=(Map<String,Object>)respArray.get(0).get("flags");
        Assert.assertEquals(respMap.get("png"),"https://flagcdn.com/w320/in.png");
    }
}
