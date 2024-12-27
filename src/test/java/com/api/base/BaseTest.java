package com.api.base;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties prop = new Properties();
    public static FileInputStream fis;
    public static Response response;
    public static String orderId;
    public static RequestSpecification reqSpec = null;
    public static String stripeCreateReqPayload;
    public static String paypalCreateReqPayload;
    public static String fileData;
    public static String clientID;
    public static String clientSecret;
    public static String access_token;

    public static void init() throws IOException {
        fis = new FileInputStream("src/test/resources/properties/config.properties");
        prop.load(fis);
        RestAssured.baseURI = prop.getProperty("baseUri");
        RestAssured.basePath = prop.getProperty("basePath");
        stripeCreateReqPayload = prop.getProperty("stripeCreateReqPayload");
        paypalCreateReqPayload=prop.getProperty("paypalCreateReqPayload");
        clientID = prop.getProperty("payPalClientId");
        clientSecret = prop.getProperty("payPalClientSecret");
    }


}
