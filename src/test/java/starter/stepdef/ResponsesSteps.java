package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.IsEqual;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesSteps {
    @Steps
    ReqresAPI reqresAPI;


    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body name should be {string} and job should be {string}")
    public void responseBodyNameShouldBeAndJobShouldBe(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));       //equalTo sama seperti AssertEqual
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String fileName) {
        File jsonFile = new File(Constants.JSON_SCHEMA + fileName);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));   //buat validasi json schema
    }

    @Given("Get list users with invalid parameter page {string}")
    public void getListUsersWithInvalidParameterPage(String stringHalaman) {
        reqresAPI.getListInvalidUsers(stringHalaman);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, IsEqual.equalTo(error));
    }

    @Given("Get list resource with invalid parameter page {string}")
    public void getListResourceWithInvalidParameterPage(String stringHalaman) {
        reqresAPI.getListInvalidResource(stringHalaman);
    }

    //list users and resource
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE, equalTo(page));
    }

    //single user and resource
    @And("Response body id should be {int}")
    public void responseBodyIdShouldBePage(int id) {
        SerenityRest.and().body(ReqresResponses.ID_SINGLE, equalTo(id)); //ctrl+click ID_SINGLE
    }

}
