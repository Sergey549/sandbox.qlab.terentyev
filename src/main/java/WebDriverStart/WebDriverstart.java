package WebDriverStart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverstart {

    protected WebDriver driver;

    protected void iniDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
