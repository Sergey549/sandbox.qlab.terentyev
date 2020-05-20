package login;
import org.junit.Test;
import pages.LoginPage;

public class LoginNegativeTests extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        String userName = "TestUser";
        String userPassword = "Password";

        new LoginPage(driver)
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkValidationWebElementIsPresent()
                .checkTextInFieldUserNameIsSaved()
                .checkPasswordFieldIsEmpty();
    }

   @Test

    public void checkUrl() {

        new LoginPage(driver)
                .openLoginPage()
                .enterButtonClick()
                .catchAnExceptionMethod()
                .checkCurrentLoginPageUrlIsTrue();
    }

}