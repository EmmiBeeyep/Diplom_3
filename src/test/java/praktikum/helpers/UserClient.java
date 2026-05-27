package praktikum.helpers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import praktikum.config.Config;

import static io.restassured.RestAssured.given;

public class UserClient {

    private String accessToken;

    @Step("Создать пользователя через api")
    public void createUser(User user) {

        RestAssured.baseURI = Config.BASE_URL;

        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .post("api/auth/register");

        response.then().statusCode(200);

        accessToken = response.body().path("accessToken");
        //System.out.println(accessToken);
    }

    @Step("Удалить пользователя через api")
    public void deleteUser() {

        if (accessToken == null) {
            return;
        }

        RestAssured.baseURI = Config.BASE_URL;

        given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }

}
