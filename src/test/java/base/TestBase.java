package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    private static WebDriver driver;

    private final AuthorizedTestBase authorizedTestBase = new AuthorizedTestBase();

    @BeforeAll
    public static void initWebDriver() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1200x750";
        //Configuration.browserCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        //options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Меняем заданный при инициализации размер окна
        driver.manage().window().setSize(new Dimension(210, 100));
        //WebDriverRunner.setWebDriver(new ChromeDriver());
        //WebDriverRunner.driver();
        //WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    @AfterAll
    public static void quitBrowser() {
        if (driver !=null)
            driver.quit();
        else System.out.println("There is no driver");
    }

    public AuthorizedTestBase getAuthorizedTestBase() {
        return authorizedTestBase;
    }
}