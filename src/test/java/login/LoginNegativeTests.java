package login;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.fail;


public class LoginNegativeTests extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        incorrectAuth("TestUser", "Password", ".//*[text()='Invalid credentials.']/..", "input[value='Войти']");

    }

    private void incorrectAuth(String username, String password, String xpathExpression, String buttonCssSelector) {
        fieldFormFilling(By.name("_username"), username);
        fieldFormFilling(By.id("password"), password);
        catchException(xpathExpression);
        getButtonClick(buttonCssSelector);
        isElementPresent(xpathExpression);
    }

    private void catchException(String xpathExpression) {
        try {
            isElementPresent(xpathExpression);
            Assertions.fail();
            fail();
        }catch (NoSuchElementException ignored){}
    }

    private void getButtonClick(String buttonCssSelector) {
        driver.findElement(By.cssSelector(buttonCssSelector)).click();
    }

    private void isElementPresent(String xpathExpression) {
        driver.findElement(By.xpath(xpathExpression));
    }

    private void fieldFormFilling(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

}