package login;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBase extends LoginPage {

    private final By cssSelector = By.cssSelector("input[value='Войти']");
    private final By xpath = By.xpath(".//*[text()='Invalid credentials.']/..");
    public WebDriver driver;
    public WebDriver wait;

    @Before
    public void initWebDriver() {

        iniWebDriver();
    }

    public void iniWebDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Меняем заданный при инициализации размер окна
        //driver.manage().window().setSize(new Dimension(210, 100));
        driver.get("https://tt-develop.quality-lab.ru/login");
        WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    @After
    public void quitBrowser() {
        driver.quit();
        if (driver != null) {
        } else System.out.println("fail");

    }

    public void login(String username, String password) {
        fillUsernameField(username);
        fillPasswordField(password);
        catchAnException();
        enterButtonClick();
        getElementPresent();
    }

    private void getElementPresent() {
        driver.findElement(xpath);
    }

    private void catchAnException() {
        try {
            getElementPresent();
            Assertions.fail();
            fail();
        } catch (NoSuchElementException ignored){}
    }

    private void enterButtonClick() {
        driver.findElement(cssSelector).click();
    }

    private void fillPasswordField(String password) {
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    private void fillUsernameField(String username) {
        driver.findElement(By.name("_username")).click();
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys(username);
    }
}
