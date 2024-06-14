package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";    //si {page} mengarah ke pathParam line 12

    public static String CREATE_USER = Constants.BASE_URL + "/api/users";

    public static String USER_WITH_ID = Constants.BASE_URL + "/api/users/{idUser}";

    public static String LOGIN_USER = Constants.BASE_URL + "/api/login";

    public static String REGISTER_USER = Constants.BASE_URL + "/api/register";

    @Step("Get list users")
    public void getListUsers(int halaman){
        SerenityRest.given()
                .pathParam("page", halaman);  // pathParam buat query parameter. yang warna putih referens ke public void
    }

    @Step("Get single user")
    public void getSingleUser(int idUser){
        SerenityRest.given()
                .pathParam("idUser", idUser);
    }

    @Step("Get list invalid users")
    public void getListInvalidUsers(String stringHalaman){
        SerenityRest.given()
                .pathParam("page", stringHalaman);  // pathParam buat query parameter. yang warna putih referens ke public void
    }

    @Step("Create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)      //tipe kontennya
                .body(json);
    }

    @Step("Create new user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)      //tipe kontennya
                .body(json);
    }

    @Step("Login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("idUser", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("idUser", id);
    }

}
