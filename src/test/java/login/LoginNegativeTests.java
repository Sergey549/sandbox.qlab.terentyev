package login;
import org.junit.Test;


public class LoginNegativeTests extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        String userName = "TestUser";
        String userPassword = "Password";

        new LoginPage()
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkValidationWebElementIsPresent();
    }

    @Test

    public void checkUrl() {

        new LoginPage()
                .openLoginPage()
                .enterButtonClick()
                .catchAnExceptionMethod()
                .checkCurrentLoginPageUrlIsTrue();
    }
}