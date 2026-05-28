package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Логин пользователя")
    public void login(String email, String password) {

        type(emailField, email);
        type(passwordField, password);
        click(loginButtonLoginPage);

    }

    @Step("Перейти на форму регистрации")
    public void clickRegistrationLink() {
        click(registrationLink);
    }

    @Step("Перейти на форму с восстановлением пароля")
    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    @Step("Нажать на линк «Вспомнили пароль? - Войти»")
    public void clickRememberedPasswordLink() {
        click(rememberedPasswordLink);
    }


    // ===============================ЛОКАТОРЫ=========================================================================

    //локатор кнопки "Войти" на странице /login
    private final By loginButtonLoginPage = By.xpath("//button[contains(text(),'Войти')]");

    //локатор поля "email" в форме "Вход"
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");

    //локатор поля "password" в форме "Вход"
    private final By passwordField = By.xpath("//input[@name='Пароль']");

    //локатор линки "Зарегистрироваться" перехода на форму "Регистрация"
    private final By registrationLink = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    //локатор линки "Восстановить пароль" перехода на форму "Восстановление пароля"
    private final By forgotPasswordLink = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    //локатор линки "Вспомнили пароль? - Войти" на странице "Восстановление пароля"
    private final By rememberedPasswordLink = By.xpath("//a[contains(text(),'Войти')]");

    //=================================================================================================================

}
