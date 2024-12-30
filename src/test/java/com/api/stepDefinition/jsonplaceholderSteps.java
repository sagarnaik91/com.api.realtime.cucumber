package com.api.stepDefinition;

import com.api.utilities.TestUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.*;
import static com.api.base.BaseTest.*;

import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class jsonplaceholderSteps {

    @Given("I send a get request")
    public void i_send_a_get_request() {
        response = given().log().all().auth().basic("", "").get();
        response.prettyPrint();
    }

    @Then("validate the total number of objects available are {int}")
    public void validate_the_total_number_of_objects_available_are(Integer int1) {
        Assert.assertEquals(TestUtilities.getArrayFromJsonResponse(response, "$").size(), 100);
    }

    @Given("I send a get request with {string} query param and value as {int}")
    public void i_send_a_get_request_with_query_param_and_value_as(String queryParam, Integer queryParamValue) {
        response = given().queryParam(queryParam,queryParamValue).log().all().auth().basic("", "").get();
        response.prettyPrint();
    }

    @Then("Validate the value of {string} is {int}")
    public void validate_the_value_of_is(String fieldName, int fieldValue) {
        List<Map<String, Object>> responseBody = TestUtilities.getArrayFromJsonResponse(response, "$");
        Assert.assertEquals(TestUtilities.getValueOfKeyFromArrayOfMap(responseBody, fieldName), fieldValue);
    }
}
