package com.api.stepDefinition;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Test1 {
    @Test
    public static void test2() throws IOException {
        //Generate chema using https://codebeautify.org/json-to-json-schema-generator
        String key = "sk_test_51KOIaSSCoDbwU91ZqitjMA6x5FtL6DLkXBev8CXrro2q2ngNRghZESfFZintw1YovUOCCvAjWZGja2t13AZ4ZIAq003CICtQ5n";
        String schemaPath = "src/test/resources/requestPayload/stripeResponse.json";
        String body = "{\n" +
                "\"email\":\"<email>\",\n" +
                "\"description\":\"<description>\"\n" +
                "}\n";
        Response res = given().log().all().auth().basic(key, "").body(body).when().post("https://api.stripe.com/v1/customers");
        res.prettyPrint();
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/requestPayload/stripeResponse.json")));
    }

}
