package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка перехода в раздел «Булки» конструктора")
    public void bunsTabTest() {

        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        mainPage.waitForActiveTab("Булки");

        Assert.assertEquals("Булки", mainPage.getActiveTab());

    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка перехода в раздел «Соусы» конструктора")
    public void saucesTabTest() {

        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.waitForActiveTab("Соусы");

        Assert.assertEquals("Соусы", mainPage.getActiveTab());

    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка перехода в раздел «Начинки» конструктора")
    public void fillingsTabTest() {

        mainPage.open();
        mainPage.clickFillingsTab();
        mainPage.waitForActiveTab("Начинки");

        Assert.assertEquals("Начинки", mainPage.getActiveTab());

    }

}
