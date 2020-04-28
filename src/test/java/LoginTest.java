import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        incorrectAuth("TestUser", "Password");

    }

    private void incorrectAuth(String username, String password) {
        driver.findElement(By.name("_username")).click();
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys(username);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Войти']")).click();
    }

}