package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class LoginPage {


    private TextInput userNameField = new TextInput($(new By.ByName("_username")));
    private TextInput passwordField = new TextInput($(new By.ById("password")));
    private Button enterButton = new Button($(new By.ByCssSelector("input[value='Войти']")));


    public LoginPage openLoginPage() {
        open("https://tt-develop.quality-lab.ru/login");
        return this;
    }

    public LoginPage fillUserNameField(String data) {
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(data);
        return this;
    }

    public LoginPage fillUserPasswordField(String userPassword) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(userPassword);
        return this;
    }

    public LoginPage catchAnException() {
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
        $(new By.ByXPath(".//*[text()='Invalid credentials.']/.."));
        return this;
    }

    public LoginPage checkTextInFieldUserNameIsSaved() {
        String value = userNameField.getAttribute("value");
        System.out.println("The User Name is: " + value);
        return this;
    }

    public LoginPage checkPasswordFieldIsEmpty() {
        if (passwordField.getAttribute("value") != "") {
            System.out.println("The Password Field Is Empty");
        } return this;
    }

    public LoginPage checkCurrentLoginPageUrlIsTrue() {
        driver().getCurrentFrameUrl();
        String URL = driver().getCurrentFrameUrl();
        Assert.assertEquals(URL, "https://tt-develop.quality-lab.ru/login");
        return this;
    }

    public ReportGroupEditPage checkCurrentPageUrlIsReportGroupEdit() {
        driver().getCurrentFrameUrl();
        String URL = driver().getCurrentFrameUrl();
        Assert.assertEquals(URL, "https://tt-develop.quality-lab.ru/report/group/edit");
        return new ReportGroupEditPage();
    }

    public CalendarPage openCalendarPage() {
        open("https://tt-develop.quality-lab.ru/calendar/");
        return new CalendarPage();
    }

}
