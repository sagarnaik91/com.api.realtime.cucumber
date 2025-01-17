package com.independentActions;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Task2 {
    @Test
    public static void getPosts() {
        Response res = given().auth().basic("", "").log().all().get("https://jsonplaceholder.typicode.com/posts/1");
        Assert.assertEquals(Integer.parseInt(res.jsonPath().getString("userId")), 1);
        //Assert.assertEquals(String.valueOf(1),"1");

    }
}
