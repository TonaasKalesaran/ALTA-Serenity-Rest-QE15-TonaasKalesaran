package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateUserSteps {

    @Steps
    ReqresAPI reqresAPI;        //buat initialize si ReqresAPI

    @Given("Create new user with file json {string}")
    public void createNewUserWithFileJson(String fileName) {
        File fileJson = new File(Constants.REQ_BODY+fileName);  //buat cari file json ada dimana
        reqresAPI.postCreateNewUser(fileJson);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest
                .when()
                .post(ReqresAPI.CREATE_USER);
    }
}
