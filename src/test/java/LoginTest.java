import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        incorrectAuth("TestUser", "Password");

    }

    private void incorrectAuth(String username, String password) {
        fieldFormFilling(By.name("_username"), username);
        fieldFormFilling(By.id("password"), password);
        driver.findElement(By.cssSelector("input[value='Войти']")).click();
    }

    private void fieldFormFilling(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

}