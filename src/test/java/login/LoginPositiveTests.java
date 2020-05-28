package login;

import base.TestBase;
import base.TestData;
import org.junit.Test;
import pages.LoginPage;
import pages.ReportGroupEditPage;

public class LoginPositiveTests extends TestBase {

    TestData data = new TestData("Сергей Терентьев", "aHbtYp2508912");

    @Test
    public void correctUserNameAndPassword() {

        ReportGroupEditPage ReportGroupEditPage = new LoginPage()
                .openLoginPage()
                .fillUserNameField(data.userName)
                .fillUserPasswordField(data.userPassword)
                .catchAnException()
                .enterButtonClick()
                .checkCurrentPageUrlIsReportGroupEdit()
                .clickAvatar()
                .checkUserData();
    }
}
