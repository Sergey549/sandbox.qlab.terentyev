package login;

import org.junit.Test;
import pages.LoginPage;
import pages.ReportGroupEditPage;

public class LoginPositiveTests extends TestBase{

    @Test
    public void correctUserNameAndPassword() {
        String userName = "Сергей Терентьев";
        String userPassword = "aHbtYp2508912";

        ReportGroupEditPage ReportGroupEditPage = new LoginPage(driver)
                .openLoginPage()
                .fillUserNameField(userName)
                .fillUserPasswordField(userPassword)
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkCurrentPageUrlIsReportGroupEdit()
                .clickAvatar()
                .checkSecondUserName()
                .checkUserEmail();
    }
}
