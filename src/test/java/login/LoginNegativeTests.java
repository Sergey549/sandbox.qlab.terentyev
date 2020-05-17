package login;
import org.junit.Test;


public class LoginNegativeTests extends TestBase {

    //@Test
    public void incorrectUserNameAndPassword() {

        String userName = "TestUser";
        String userPassword = "Password";

        new LoginPage()
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkValidationWebElementIsPresent()
                .checkTextInFieldUserNameIsSaved()
                .checkPasswordFieldIsEmpty();
    }


    //@Test

    public void checkUrl() {

        new LoginPage()
                .openLoginPage()
                .enterButtonClick()
                .catchAnExceptionMethod()
                .checkCurrentLoginPageUrlIsTrue();
    }


    @Test
    public void correctUserNameAndPassword() {
        String userName = "Сергей Терентьев";
        String userPassword = "aHbtYp2508912";

        ReportGroupEditPage ReportGroupEditPage = new LoginPage()
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkCurrentPageUrlIsReportGroupEdit()
                .clickAvatar()
                .checkSecondUserName();
    }
}