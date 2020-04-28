import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @Before
    public void initWebDriver() {
        iniWebDriver();
    }

    private void iniWebDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
