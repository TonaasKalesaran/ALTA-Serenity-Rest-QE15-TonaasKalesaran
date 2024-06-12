package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with parameter id {int} and valid json {string}")
    public void updateUserWithParameterIdAndValidJson(int id, String jsonFileName) {
        File fileJson = new File(Constants.REQ_BODY+jsonFileName);  //buat cari file json ada dimana
        reqresAPI.putUpdateUser(id, fileJson);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest
                .when()
                .put(ReqresAPI.USER_WITH_ID);
    }
}
