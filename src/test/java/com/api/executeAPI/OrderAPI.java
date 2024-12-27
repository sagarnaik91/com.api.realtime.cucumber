package com.api.executeAPI;

import com.api.base.BaseTest;
import com.api.pojo.Amount;
import com.api.pojo.Orders;
import com.api.pojo.PurchaseUnits;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class OrderAPI extends BaseTest {
    //static String orderId;
    public static String getAccessToken() {
        response = given().param("grant_type", "client_credentials")
                .auth().preemptive().basic(clientID, clientSecret)
                .post("v1/oauth2/token");
        response.prettyPrint();
        access_token = response.jsonPath().getString("access_token");
        return access_token;
    }

    public static Response createOrder(String currency_code, String value) {
        ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
        list.add(new PurchaseUnits("d9f80740-38f0-11e8-b467-0ed5f89f718c", currency_code, value));
        Orders orders = new Orders("CAPTURE", list);
        response = given().log().all().contentType(ContentType.JSON).auth().oauth2(getAccessToken()).body(orders).post("/v2/checkout/orders");
        System.out.println("------------Response of create order------------");
        response.prettyPrint();
        orderId = response.jsonPath().getString("id");
        return response;
    }

    public static Response getOrder() {
        System.out.println(orderId + " is the orderId");
        return given().log().all().auth().oauth2(getAccessToken()).get("v2/checkout/orders" + "/" + orderId);

    }

    public static Response createOrder(String currency_code, String value, String referenceId) throws IOException {
        fileData = new String(Files.readAllBytes(Paths.get(paypalCreateReqPayload)));
        fileData = fileData.replace("<reference_id>", referenceId);
        fileData = fileData.replace("<currency_code>", currency_code);
        fileData = fileData.replace("<value>", value);
        response = given().log().all().contentType(ContentType.JSON).auth().oauth2(access_token).body(fileData).post("/v2/checkout/orders");
        response.prettyPrint();
        return response;
    }
}
