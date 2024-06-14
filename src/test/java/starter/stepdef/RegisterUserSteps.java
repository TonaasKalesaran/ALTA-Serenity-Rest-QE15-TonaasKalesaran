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

public class RegisterUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Register new user with file json {string}")
    public void registerNewUserWithFileJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);  //buat cari file json ada dimana
        reqresAPI.postRegisterUser(fileJson);
    }

    @And("Response body id should be {int} and token should be {string}")
    public void responseBodyIdShouldBeIdAndTokenShouldBe(int id,String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest
                .when()
                .post(ReqresAPI.REGISTER_USER);
    }

    @Given("Register user with invalid json {string}")
    public void registerUserWithInvalidJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);  //buat cari file json ada dimana
        reqresAPI.postRegisterUser(fileJson);
    }

}
