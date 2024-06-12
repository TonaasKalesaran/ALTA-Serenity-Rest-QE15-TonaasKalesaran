package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class DeleteUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        //File fileJson = new File(Constants.REQ_BODY+jsonFileName);  //buat cari file json ada dimana
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest
                .when()
                .delete(ReqresAPI.USER_WITH_ID);
    }
}
