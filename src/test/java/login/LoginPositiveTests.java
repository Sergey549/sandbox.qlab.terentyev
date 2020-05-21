package login;

import org.junit.Test;
import pages.LoginPage;
import pages.ReportGroupEditPage;

public class LoginPositiveTests extends TestBase{

    @Test
    public void correctUserNameAndPassword() {

        ReportGroupEditPage ReportGroupEditPage = new LoginPage(driver)
                .openLoginPage()
                .fillUserNameField("Сергей Терентьев")
                .fillUserPasswordField("aHbtYp2508912")
                .catchAnExceptionMethod()
                .enterButtonClick()
                .checkCurrentPageUrlIsReportGroupEdit()
                .clickAvatar()
                .checkUserData();
    }
}
