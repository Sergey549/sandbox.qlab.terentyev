package login;

import org.junit.Test;


public class LoginNegativeTests extends TestBase {


    @Test
    public void incorrectUserNameAndPassword() {

        loginPage.login("TestUser", "Password");
    }


}
