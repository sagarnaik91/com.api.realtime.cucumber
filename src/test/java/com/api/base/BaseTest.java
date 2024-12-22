package com.api.base;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties prop = new Properties();
    public static FileInputStream fis;
    public static Response response;

    public static void init() throws IOException {
        fis = new FileInputStream("src/test/resources/properties/config.properties");
        prop.load(fis);
        RestAssured.baseURI = prop.getProperty("baseUri");
        RestAssured.basePath = prop.getProperty("basePath");
    }


}
