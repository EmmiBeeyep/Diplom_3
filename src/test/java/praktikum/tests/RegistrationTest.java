package praktikum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.helpers.User;
import praktikum.helpers.UserGenerator;
import praktikum.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;

    @Before
    public void setUpRegistrationPage() {

        registrationPage = new RegistrationPage(driver);
        registrationPage.open();

    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistrationTest() {

        User user = UserGenerator.getRandomUser();

        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());

        Assert.assertTrue(registrationPage.isLoginPageOpened());

    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    public void incorrectPasswordTest() {

        User user = UserGenerator.getRandomUser();

        registrationPage.register(user.getName(), user.getEmail(),"123");

        Assert.assertTrue(registrationPage.isIncorrectPasswordDisplayed());

    }

}
