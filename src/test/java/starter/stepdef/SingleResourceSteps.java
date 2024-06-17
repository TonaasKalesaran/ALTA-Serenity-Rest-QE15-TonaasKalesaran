package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import static org.hamcrest.Matchers.equalTo;

public class SingleResourceSteps {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single resource with parameter {int}")
    public void getSingleResourceWithParameterId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.RESOURCE_WITH_ID);
    }
}
