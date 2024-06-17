package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import static org.hamcrest.Matchers.equalTo;

public class ListResourceSteps {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPage(int page) {
        reqresAPI.getListResource(page);   //pagenya bisa hardcode sesuai angka(2)
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }
}
