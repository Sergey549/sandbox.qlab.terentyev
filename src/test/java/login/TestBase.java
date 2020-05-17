package login;

import com.sun.glass.ui.Accessible;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @Before
    public void initWebDriver() {
        iniWebDriver();
    }

    public void iniWebDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //Запуск браузера в окне размером 500х500
        //options.addArguments("--window-size=500,500");
        //Запуск браузера на весь экран
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Меняем заданный при инициализации размер окна
        //driver.manage().window().setSize(new Dimension(210, 100));
        driver.get("https://tt-develop.quality-lab.ru/login");
        WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    @After
    public void quitBrowser() {
        if (driver != null)
            driver.quit();
        else System.out.println("There is no driver");
    }

    public class LoginPage {

        @FindBy(name = "_username")
        private WebElement userField;

        @FindBy(id = "password")
        private WebElement passwordField;

        @FindBy(css = "input[value='Войти']")
        private WebElement enterButton;

        @FindBy(xpath = ".//*[text()='Invalid credentials.']/..")
        private WebElement hiddenValidationWebElement;


        public LoginPage openLoginPage() {
            driver.get("https://tt-develop.quality-lab.ru/login");
            PageFactory.initElements(driver, this);
            return this;
        }

        public LoginPage fillUserNameField(String userName) {
            userField.click();
            userField.clear();
            userField.sendKeys(userName);
            return this;
        }

        public LoginPage fillUserPasswordField(String userPassword) {
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(userPassword);
            return this;
        }

        public LoginPage catchAnExceptionMethod() {
            try {
                checkValidationWebElementIsPresent();
            } catch (NoSuchElementException ignored) {
               }
            return this;
        }

        public LoginPage enterButtonClick() {
            enterButton.click();
            return this;
        }

        public LoginPage checkValidationWebElementIsPresent() {
            hiddenValidationWebElement.isDisplayed();
            return this;
        }

        public LoginPage checkTextInFieldUserNameIsSaved() {
            String value = userField.getAttribute("value");
            System.out.println("The UserMane attribute value is: " + value);
            return this;
        }

        public LoginPage checkPasswordFieldIsEmpty() {
            if (passwordField.getAttribute("value") != "") {
                System.out.println("The Password Field Is Empty");
            }
            return this;
        }

        public LoginPage checkCurrentLoginPageUrlIsTrue() {
            driver.getCurrentUrl();
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://tt-develop.quality-lab.ru/login");
            return this;
        }

        public ReportGroupEditPage checkCurrentPageUrlIsReportGroupEdit() {
            driver.getCurrentUrl();
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://tt-develop.quality-lab.ru/report/group/edit");
            return new ReportGroupEditPage(driver);
        }
    }

    public class ReportGroupEditPage {

        private final WebDriver driver;

        @FindBy(xpath = "//span/div/div")
        private WebElement avatarImput;

        @FindBy(css = "div[class='m-card-user__details']")
        private WebElement secondName;


        public ReportGroupEditPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        public ReportGroupEditPage clickAvatar() {
            avatarImput.click();
            return this;
        }

        public ReportGroupEditPage checkSecondUserName() {
            String value = secondName.getText();
            System.out.println("The UserMane attribute value is: " + value);
            return this;
        }

        public ReportGroupEditPage checkUserEmail() {
            ///???
            return this;
        }
    }
}