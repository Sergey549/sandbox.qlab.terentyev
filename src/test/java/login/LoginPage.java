package login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By cssSelector = By.cssSelector("input[value='Войти']");
    private final By xpath = By.xpath(".//*[text()='Invalid credentials.']/..");
    private final By name = By.name("_username");
    private final By userPassword = By.id("password");


    public WebDriver driver;

    public void icorrectLogin(String username, String password) {
        fillUsernameField(username);
        fillPasswordField(password);
        catchAnException();
        enterButtonClick();
        getElementPresent();
    }

    public void correctLogin(String username, String password) {
        fillUsernameField(username);
        fillPasswordField(password);
        catchAnException();
        enterButtonClick();
        catchAnException();
        redirecttCheck();
        checkCorrectUserData();
    }

    public void fillUsernameField(String username) {

        type(username, name);
    }
    public void fillPasswordField(String password) {
        type(password, userPassword);
    }

    public void enterButtonClick() {
        driver.findElement(cssSelector).click();
    }

    public void getElementPresent() {
        driver.findElement(xpath);
    }

    public void catchAnException() {
        try {
            getElementPresent();
        } catch (NoSuchElementException ignored){
            System.out.println("The entered userdata is correct. You will be logged in");
        }
    }

    public void redirecttCheck() {

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://tt-develop.quality-lab.ru/report/group/edit" );
    }

    public void checkCorrectUserData() {
        driver.findElement(By.id("m_header_topbar"));
        driver.findElement(By.id("m_header_topbar")).click();
        driver.findElement(By.cssSelector("div[class='m-card-user m-card-user--skin-dark']")).getAttribute("");
        //driver.findElement(By.id("div[class='m-card-user m-card-user--skin-dark']")).getAttribute("fake+329@quality-lab.ru");

    }

    private void type(String password, By userPassword) {
        driver.findElement(userPassword).click();
        driver.findElement(userPassword).clear();
        driver.findElement(userPassword).sendKeys(password);
    }


}
