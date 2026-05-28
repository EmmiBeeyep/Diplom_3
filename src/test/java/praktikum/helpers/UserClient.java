package praktikum.helpers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import praktikum.config.Config;

import static io.restassured.RestAssured.given;
import static praktikum.helpers.Endpoints.REGISTER;
import static praktikum.helpers.Endpoints.USER;
import static org.apache.http.HttpStatus.*;

public class UserClient {

    private String accessToken;

    @Step("Создать пользователя через api")
    public void createUser(User user) {

        RestAssured.baseURI = Config.BASE_URL;

        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .post(REGISTER);

        response.then().statusCode(SC_OK);

        accessToken = response.body().path("accessToken");

    }

    @Step("Удалить пользователя через api")
    public void deleteUser() {

        if (accessToken == null) {
            return;
        }

        RestAssured.baseURI = Config.BASE_URL;

        given()
                .header("Authorization", accessToken)
                .delete(USER);
    }

}
