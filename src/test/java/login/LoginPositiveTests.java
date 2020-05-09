package login;

import org.junit.Test;

public class LoginPositiveTests extends TestBase {

    @Test
    public void correctUserNameAndPassword() {

        loginPage.correctLogin("Сергей Терентьев", "aHbtYp2508912");

    }

}
