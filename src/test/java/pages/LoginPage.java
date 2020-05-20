package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class LoginPage extends HtmlElement {

    private final WebDriver driver;

    @FindBy(name = "_username")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "input[value='Войти']")
    private WebElement enterButton;

    @FindBy(xpath = ".//*[text()='Invalid credentials.']/..")
    private WebElement hiddenValidationWebElement;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.get("https://tt-develop.quality-lab.ru/login");
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
        System.out.println("The User Name is: " + value);
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
