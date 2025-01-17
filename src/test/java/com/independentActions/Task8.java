package com.independentActions;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class Task8 {
    @Test
    public static void validateSchema() {

        Response res = given().log().all().auth().basic("", "").get("https://jsonplaceholder.typicode.com/posts/1/comments");
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/responseSchema/jsonPlaceholderSchema")));
    }
}
