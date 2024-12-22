package com.api.stepDefinition;

import com.api.base.BaseTest;
import com.api.executeAPI.OrderAPI;
import com.api.utilities.TestUtilities;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

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
        BaseTest.response = OrderAPI.createOrder(currencycode, currencyvalue);

    }

    @When("I verify status as CREATED")
    public void i_verify_status_as_CREATED() {
        Assert.assertEquals(TestUtilities.getJsonKeyValue(BaseTest.response.asString(), "status"), "CREATED");

    }

    @When("I get order from paypal api")
    public void i_get_order_from_paypal_api() {
      BaseTest.response=OrderAPI.getOrder();

    }

    @When("I verify status code as {int}")
    public void i_verify_status_code_as(int statusCode) {
        Assert.assertEquals(BaseTest.response.getStatusCode(),statusCode);
    }

}
