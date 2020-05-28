package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    private WebDriver driver;
    public WebDriverRunner driverRunner;

    @Before
    public void initWebDriver() {

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

    @After
    public void quitBrowser() {
        if (driver !=null)
            driver.quit();
        else System.out.println("There is no driver");
    }
}