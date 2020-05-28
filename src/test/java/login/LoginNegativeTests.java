package login;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import pages.LoginPage;

public class LoginNegativeTests extends TestBase {

    TestData negativeData = new TestData("TestUser", "Password");

    @Test
    public void incorrectUserNameAndPassword() {

        new LoginPage()
                .openLoginPage()
                .fillUserNameField(negativeData.userName)
                .fillUserPasswordField(negativeData.userPassword)
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