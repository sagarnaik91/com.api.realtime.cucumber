package com.independentActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Task1 {
    public static void getComment() {
        Response res = given().auth().basic("", "").log().all().get("https://jsonplaceholder.typicode.com/posts/1/comments");
        List<Map<String, Object>> responseArray = res.jsonPath().getList("$");
        Assert.assertEquals(responseArray.get(0).get("email"), "Eliseo@gardner.biz");
    }
}
