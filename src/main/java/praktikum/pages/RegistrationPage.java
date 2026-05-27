package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.config.Config;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        type(nameFieldRegPage, name);
        type(emailFieldRegPage, email);
        type(passFieldRegPage, password);

        click(regButtonRegPage);
    }

    @Step("Проверить отображение ошибки некорректного пароля")
    public boolean isIncorrectPasswordDisplayed() {
        return isDisplayed(incorrectPasswordText);
    }

    @Step("Перейти на форму входа (из формы регистрации)")
    public void clickAlreadyRegisteredLink() {
        click(alreadyRegisteredLink);
    }

    @Step("Проверить переход на страницу /login")
    public boolean isLoginPageOpened() {
        return waitForUrlToBe(Config.LOGIN_URL);
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get(Config.REGISTER_URL);
    }

    // ===============================ЛОКАТОРЫ=========================================================================

    //локатор поля "Имя" на странице регистрации
    private final By nameFieldRegPage = By.cssSelector("input[name=\"name\"][type=\"text\"]");

    //локатор поля "Email" на странице регистрации
    private final By emailFieldRegPage = By.xpath("//label[text()=\"Email\"]/following-sibling::input");

    //локатор поля "Пароль" на странице регистрации
    private final By passFieldRegPage = By.cssSelector("input[type=\"password\"][name=\"Пароль\"]");

    //локатор кнопки "Зарегистрироваться" на странице регистрации
    private final By regButtonRegPage = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    //локатор ошибки "Некорректный пароль" в поле "Пароль" на странице регистрации
    private final By incorrectPasswordText = By.xpath("//p[@class='input__error text_type_main-default']");

    //локатор линки "Уже зарегистрированы? - Войти" на странице регистрации
    private final By alreadyRegisteredLink = By.xpath("//a[contains(text(),'Войти')]");

    //=================================================================================================================

}
