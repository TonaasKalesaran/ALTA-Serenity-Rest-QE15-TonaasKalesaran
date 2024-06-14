package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserSteps {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with parameter {int}")
    public void getSingleUserWithParameterId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.USER_WITH_ID);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBePage(int id) {
        SerenityRest.and().body(ReqresResponses.ID_SINGLE, equalTo(id)); //ctrl+click ID_SINGLE
    }
}
