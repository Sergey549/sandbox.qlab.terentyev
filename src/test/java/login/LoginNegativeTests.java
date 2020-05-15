package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginNegativeTests extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        String userName = "TestUser";
        String userPassword = "Password";

        new ModernLoginPage()
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkValidationWebElementIsPresent();
    }

    @Test

    public void checkUrl() {

        new ModernLoginPage()
                .openLoginPage()
                .enterButtonClick()
                .catchAnExceptionMethod()
                .checkCurrentUrlIsLoginPage();
    }



    
    public class ModernLoginPage {

        @FindBy(name = "_username")
        private WebElement userField;

        @FindBy(id = "password")
        private WebElement passwordField;

        @FindBy(css = "input[value='Войти']")
        private WebElement enterButton;

        @FindBy(xpath = ".//*[text()='Invalid credentials.']/..")
        private WebElement hiddenValidationWebElement;


        public ModernLoginPage openLoginPage() {
            driver.get("https://tt-develop.quality-lab.ru/login");
            PageFactory.initElements(driver, this);
            return this;
        }

        public ModernLoginPage fillUserNameField(String userName) {
            userField.click();
            userField.clear();
            userField.sendKeys(userName);
            return this;
        }

        public ModernLoginPage fillUserPasswordField(String userPassword) {
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(userPassword);
            return this;
        }

        public ModernLoginPage catchAnExceptionMethod() {
            try {
                checkValidationWebElementIsPresent();
            } catch (NoSuchElementException ignored) {
                System.out.println("The entered userdata is correct. You will be logged in");
            }
            return this;
        }

        public ModernLoginPage enterButtonClick() {
            enterButton.click();
            return this;
        }

        public ModernLoginPage checkValidationWebElementIsPresent() {
            hiddenValidationWebElement.isDisplayed();
            return this;
        }

        public ModernLoginPage checkCurrentUrlIsLoginPage() {
            driver.getCurrentUrl();
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://tt-develop.quality-lab.ru/login");
            return this;
        }
    }

}