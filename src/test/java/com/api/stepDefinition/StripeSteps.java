package com.api.stepDefinition;

import com.api.base.BaseTest;
import com.api.utilities.TestUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.api.base.BaseTest.prop;
import static io.restassured.RestAssured.given;

public class StripeSteps{
    String filePath = "src/test/resources/requestPayload/stripeCreateRequest";
    String fileData;
    public RequestSpecification reqSpec = null;
    public Response res = null;

    @Given("I set the valid auth key")
    public void i_set_the_valid_auth_key() {
        reqSpec = given().log().all().auth().basic(prop.getProperty("validSecretKey"), "");
    }

    @Given("I set {string} as the email in the parameter")
    public void i_set_as_the_email_in_the_parameter(String email) {
        reqSpec = reqSpec.log().all().formParam("email", email);
    }


    @Given("I set {string} as the description in the parameter")
    public void i_set_as_the_description_in_the_parameter(String description) {
        reqSpec = reqSpec.log().all().formParam("description", description);
    }

    @When("I send a Post request to url")
    public void i_send_a_Post_request_to() {
        RestAssured.baseURI = prop.getProperty("baseUri");
        RestAssured.basePath = prop.getProperty("basePath");
        res = reqSpec.log().all().post(prop.getProperty("customerApiEndpoint"));
        res.prettyPrint();

    }

    @Then("I should get {int} as the expected status code")
    public void i_should_get_as_the_expected_status_code(int expectedStatusCode) {
        Assert.assertEquals(res.statusCode(), expectedStatusCode);
    }

    @Then("I should have the {string} field in the response")
    public void i_should_have_the_field_in_the_response(String id) {
        Assert.assertTrue(TestUtilities.hasKey(res.asString(), id));
    }

    @Then("we should get get {string} as email in the response")
    public void we_should_get_get_as_email_in_the_response(String expectedEmail) {
        Assert.assertEquals(TestUtilities.getJsonKeyValue(res.asString(), "email"), expectedEmail);
    }

    @Then("we should get {string} as description the response")
    public void we_should_get_as_description_the_response(String expectedDescription) {
        Assert.assertEquals(TestUtilities.getJsonKeyValue(res.asString(), "description"), expectedDescription);
    }

    @When("I send a request to url")
    public void i_send_a_request_to_url() {
        RestAssured.baseURI = prop.getProperty("baseUri");
        RestAssured.basePath = prop.getProperty("basePath");
        res = given().log().all().auth().basic(prop.getProperty("validSecretKey"), "").body(fileData).post(prop.getProperty("customerApiEndpoint"));
        res.prettyPrint();
    }

    @Then("I should get {string} and {string} as the expected status code")
    public void i_should_get_and_as_the_expected_status_code(String objectLocator, String fieldToBeValidated) {
        Map<String, String> mapOfJson = new HashMap<>();
        mapOfJson = TestUtilities.getJsonKeyValueFromMap(res, objectLocator);
        System.out.println("----->>>>>>>" + mapOfJson.size());
        Assert.assertTrue(mapOfJson.get(fieldToBeValidated) == null);
    }

    @Then("validate the schema passed in {string}")
    public void validate_the_schema_passed_in(String schemaPath) {
        res.prettyPrint();
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }

    @Given("I set {string} in the description")
    public void i_set_in_the_description(String description) throws IOException {
        //fileData = new String(Files.readAllBytes(Paths.get(filePath)));
        fileData = fileData.replace("<description>", description);
    }

    @Given("I setup {string} in the field email")
    public void i_setup_in_the_field_email(String email) throws IOException {
        fileData = new String(Files.readAllBytes(Paths.get(filePath)));
        fileData = fileData.replace("<email>", email);
    }
}
