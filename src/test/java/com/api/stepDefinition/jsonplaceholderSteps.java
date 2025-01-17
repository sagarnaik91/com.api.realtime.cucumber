package com.api.stepDefinition;

import com.api.executeAPI.JsonPlaceholderAPI;
import com.api.utilities.TestUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.*;
import static com.api.base.BaseTest.*;

import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        response = given().queryParam(queryParam, queryParamValue).log().all().auth().basic("", "").get();
        response.prettyPrint();
    }

    @Then("Validate the value of {string} is {int}")
    public void validate_the_value_of_is(String fieldName, int fieldValue) {
        List<Map<String, Object>> responseBody = TestUtilities.getArrayFromJsonResponse(response, "$");
        Assert.assertEquals(TestUtilities.getValueOfKeyFromArrayOfMap(responseBody, fieldName), fieldValue);
    }

    @Given("I send a get request with {int} in the path param")
    public void i_send_a_get_request_with_in_the_path_param(Integer id) {
        response = JsonPlaceholderAPI.getApiWithPathParam(id);
        response.prettyPrint();
    }

    @Then("Validate statusCode returned is {int}")
    public void validate_statusCode_returned_is(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("Validate only one block is returned for a id")
    public void validate_only_one_block_is_returned_for_a_id() {
        Map<String, String> res = new HashMap<>();
        res = TestUtilities.getMapFromJsonResponse(response, "$");
        Assert.assertEquals(TestUtilities.getCountOfObject(res), 4);
    }

    @Given("I send a get request with {int} and comments in the path param")
    public void i_send_a_get_request_with_and_comments_in_the_path_param(Integer postId) {
        response = JsonPlaceholderAPI.getAPIWithPostIdComments(postId);
    }


    @Then("Validate the {string}")
    public void validate_the(String name) {
        List<Map<String, Object>> respBody = TestUtilities.getArrayFromJsonResponse(response, "$");
        Object nameofCx = TestUtilities.getValueOfKeyFromArrayOfMap(respBody, "name");
        Assert.assertEquals(nameofCx, name);
    }
}
