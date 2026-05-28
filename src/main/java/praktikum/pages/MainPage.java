package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static praktikum.config.Config.BASE_URL;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Нажать на кнопку «Войти в аккаунт»")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Нажать на кнопку «Личный Кабинет»")
    public void clickPersonalAccount() {
        click(personalAccountButton);
    }

    @Step("Перейти в раздел «Булки»")
    public void clickBunsTab() {
        click(bunsTab);
    }

    @Step("Перейти в раздел «Соусы»")
    public void clickSaucesTab() {
        click(saucesTab);
    }

    @Step("Перейти в раздел «Начинки»")
    public void clickFillingsTab() {
        click(fillingsTab);
    }

    @Step("Получить текст активной вкладки")
    public String getActiveTab() {
        return driver.findElement(activeTab).getText().trim();
    }

    public void waitForActiveTab(String expectedTab) {
        wait.until(driver ->
                driver.findElement(activeTab)
                        .getText()
                        .equals(expectedTab));
    }

    @Step("Проверить наличие кнопки «Оформить заказ»")
    public boolean isOrderButtonDisplayed() {
        return isDisplayed(orderButton);
    }

    // ===============================ЛОКАТОРЫ=========================================================================

    //локатор кнопки "Войти в аккаунт" на главной странице
    private final By loginButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    //локатор кнопки "Личный кабинет"
    private final By personalAccountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    //локатор вкладки "Булки" конструктора бургера
    private final By bunsTab = By.xpath("//span[contains(text(),'Булки')]");

    //локатор вкладки "Соусы" конструктора бургера
    private final By saucesTab = By.xpath("//span[contains(text(),'Соусы')]");

    //локатор вкладки "Начинки" конструктора бургера
    private final By fillingsTab = By.xpath("//span[contains(text(),'Начинки')]");

    //локатор активной вкладки конструктора бургера
    private final By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current')]");

    //локатор кнопки "Оформить заказ" на главной странице
    private final By orderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");

    //=================================================================================================================

}
