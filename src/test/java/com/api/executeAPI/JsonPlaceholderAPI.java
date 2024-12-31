package com.api.executeAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JsonPlaceholderAPI {


    public static Response getApiWithPathParam(int id) {
        return given().log().all().contentType(ContentType.JSON).get(String.valueOf(id));

    }
}
