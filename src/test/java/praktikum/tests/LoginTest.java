package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.helpers.UserClient;
import praktikum.helpers.User;
import praktikum.helpers.UserGenerator;
import praktikum.pages.LoginPage;
import praktikum.pages.RegistrationPage;

public class LoginTest extends BaseTest {

    private User user;
    private UserClient userClient;

    @Before
    public void createUser() {

        userClient = new UserClient();

        user = UserGenerator.getRandomUser();

        new UserClient().createUser(user);

    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка входа через кнопку «Войти в аккаунт на главной странице»")
    public void loginFromMainPageTest() {

        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.isOrderButtonDisplayed());

    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа через кнопку «Личный кабинет» в шапке")
    public void loginFromPersonalAccountTest() {

        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickPersonalAccount();
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.isOrderButtonDisplayed());

    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа через кнопку «Уже зарегистрированы? - Войти» в форме регистрации")
    public void loginFromRegistrationFormTest() {

        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickAlreadyRegisteredLink();
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.isOrderButtonDisplayed());

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа через кнопку «Вспомнили пароль? - Войти» в форме восстановления пароля")
    public void loginFromRForgotPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickForgotPassword();
        loginPage.clickRememberedPasswordLink();
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.isOrderButtonDisplayed());

    }

    @After
    public void cleanUp() {

        if (userClient != null) {
            userClient.deleteUser();
        }

    }

}
