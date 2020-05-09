package login;

import org.junit.Assert;
import org.junit.Test;


public class LoginNegativeTests extends TestBase {


    @Test
    public void incorrectUserNameAndPassword() {

        loginPage.icorrectLogin("TestUser", "Password");
    }

    @Test
    public void urlCheck () {

        loginPage.enterButtonClick();
        loginPage.catchAnException();
        String url = loginPage.driver.getCurrentUrl();
        Assert.assertEquals(url, "https://tt-develop.quality-lab.ru/login" );

    }
}
