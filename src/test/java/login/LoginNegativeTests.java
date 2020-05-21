package login;
import org.junit.Test;
import pages.LoginPage;

public class LoginNegativeTests extends TestBase {

    @Test
    public void incorrectUserNameAndPassword() {

        new LoginPage(driver)
                .openLoginPage()
                .fillUserNameField("TestUser")
                .fillUserPasswordField("Password")
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkValidationWebElementIsPresent()
                .checkTextInFieldUserNameIsSaved()
                .checkPasswordFieldIsEmpty();
    }

  // @Test

    public void checkUrl() {

        new LoginPage(driver)
                .openLoginPage()
                .enterButtonClick()
                .catchAnExceptionMethod()
                .checkCurrentLoginPageUrlIsTrue();
    }

}