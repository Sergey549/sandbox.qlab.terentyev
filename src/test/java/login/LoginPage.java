package login;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginPage {
    private final By cssSelector = By.cssSelector("input[value='Войти']");
    private final By xpath = By.xpath(".//*[text()='Invalid credentials.']/..");
    public WebDriver driver;

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
