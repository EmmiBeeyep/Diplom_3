package praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.pages.MainPage;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("yandex")) {
            WebDriverManager.chromedriver().browserVersion("146").setup();
            ChromeOptions options = new ChromeOptions();

            options.setBinary(System.getProperty("yandex.path"));

            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        mainPage = new MainPage(driver);

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
