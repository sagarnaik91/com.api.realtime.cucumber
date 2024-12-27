package com.api.stepDefinition;

import com.api.base.BaseTest;
import com.api.executeAPI.OrderAPI;
import com.api.utilities.TestUtilities;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.api.base.BaseTest.orderId;
import static com.api.base.BaseTest.response;

public class PayPalSteps {
    @Before
    public static void setup() throws IOException {
        BaseTest.init();
    }

    @Given("I want to get access token from paypal api")
    public void i_want_to_get_access_token_from_paypal_api() {
        OrderAPI.getAccessToken();
    }

    @When("I set currency code as {string} and value as {string}")
    public void i_set_currency_code_as_and_value_as(String currencycode, String currencyvalue) {
        response = OrderAPI.createOrder(currencycode, currencyvalue);
        orderId = TestUtilities.getJsonKeyValue(response.asString(), "id");


    }

    @When("I verify status as CREATED")
    public void i_verify_status_as_CREATED() {
        orderId = TestUtilities.getJsonKeyValue(response.asString(), "id");
        Assert.assertEquals(TestUtilities.getJsonKeyValue(response.asString(), "status"), "CREATED");

    }

    @When("I get order from paypal api")
    public void i_get_order_from_paypal_api() {
        response = OrderAPI.getOrder();
    }

    @When("I verify status code as {int}")
    public void i_verify_status_code_as(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("validate the first rel is {string}")
    public void validate_the_first_rel_is(String links) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String, String>> listOfJson = new ArrayList<>();
        listOfJson = TestUtilities.getJsonKeyValueFromArray(response, links);
        System.out.println("Size of listOfJson is ---->" + listOfJson.size());
        for (int i = 0; i < listOfJson.size(); i++) {
            if (listOfJson.get(i).get("rel").equals("update")) {
                System.out.println("orderId is--->" + orderId);
                Assert.assertTrue(listOfJson.get(i).get("href").contains(orderId));

            }
        }
    }

    @When("I set currency code as {string} and value as {string} and {string}")
    public void i_set_currency_code_as_and_value_as_and(String currency_code, String value, String referenceId) throws IOException {
        response = OrderAPI.createOrder(currency_code, value, referenceId);
        orderId = response.jsonPath().getString("id");

    }

}
