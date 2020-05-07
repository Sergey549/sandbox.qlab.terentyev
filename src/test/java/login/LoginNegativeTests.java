package login;

import org.junit.Test;


public class LoginNegativeTests extends TestBase {


    @Test
    public void incorrectUserNameAndPassword() {

        login("TestUser", "Password");
    }


}
