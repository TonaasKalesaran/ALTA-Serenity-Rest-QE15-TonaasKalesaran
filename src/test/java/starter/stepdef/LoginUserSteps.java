package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;

public class LoginUserSteps {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with valid json {string}")
    public void loginUserWithValidJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);  //buat cari file json ada dimana
        reqresAPI.postLoginUser(fileJson);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest
                .when()
                .post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        //token = "QpwL5tke4Pnpja7X4";
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @Given("Login user with invalid json {string}")
    public void loginUserWithInvalidJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);  //buat cari file json ada dimana
        reqresAPI.postLoginUser(fileJson);
    }


}
