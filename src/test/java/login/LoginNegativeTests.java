package login;

import base.TestBase;
import base.TestData;
import org.junit.Test;
import pages.LoginPage;



public class LoginNegativeTests extends TestBase {

    TestData data = new TestData("TestUser", "Password");

    @Test
    public void incorrectUserNameAndPassword() {

        new LoginPage()
                .openLoginPage()
                .fillUserNameField(data.userName)
                .fillUserPasswordField(data.userPassword)
                .catchAnException()
                .enterButtonClick()
                .checkValidationWebElementIsPresent()
                .checkTextInFieldUserNameIsSaved()
                .checkPasswordFieldIsEmpty();
    }

  @Test

    public void checkUrl() {

        new LoginPage()
                .openLoginPage()
                .enterButtonClick()
                .catchAnException()
                .checkCurrentLoginPageUrlIsTrue();
    }
}