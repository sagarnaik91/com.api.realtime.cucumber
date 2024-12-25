package com.api.stepDefinition;

import com.api.pojo.Orders;
import com.api.pojo.PurchaseUnits;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test {
    public static String username = "AQV5GfG1KCuIP2YLegv95MUSBo_PeOfBAMU5f2cL-bqOcIG98ZoaqAjXfkW4ysbi5VujgIlxSDYLfpCt";
    public static String password = "EB7jQzo5EyMM9LKx5-zVIS3gohhT7vzGvUQQzc2dQ9bYtGoVoJlG5pmDZblyQDdv0m6C3nGoQd5ws-Ct";

    @org.testng.annotations.Test
    public static void test1() {
        Response res = given().log().all().param("grant_type", "client_credentials").auth().preemptive().basic(username, password).post("https://api-m.sandbox.paypal.com/v1/oauth2/token");
        String access_token = res.jsonPath().getString("access_token");
        ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
        list.add(new PurchaseUnits("d9f80740-38f0-11e8-b467-0ed5f89f718c", "USD", "100"));
        Orders orders = new Orders("CAPTURE", list);
        Response res1 = given().contentType(ContentType.JSON).log().all().auth().oauth2(access_token).body(orders).post("https://api-m.sandbox.paypal.com/v2/checkout/orders");
        res1.prettyPrint();
        String id = res1.jsonPath().getString("id");
        System.out.println("id is----->"+id);
        List<Map<String, String>> listOfLinks = res1.jsonPath().getList("links");
        for (int i = 0; i < listOfLinks.size(); i++) {
            System.out.println("Size of listOfLinks is ---->" + listOfLinks.size());
            if (listOfLinks.get(i).get("rel").equals("capture")) {
                Assert.assertTrue(listOfLinks.get(i).get("href").contains(id));
            }
        }

    }
}
