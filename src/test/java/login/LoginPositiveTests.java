package login;

import base.AuthorizedTestBase;
import base.TestBase;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.ReportGroupEditPage;

public class LoginPositiveTests extends TestBase {

    AuthorizedTestBase authorization = new AuthorizedTestBase();
    @Test
    public void checkAuthorizedUserData() {
        authorization.Authorization();
        ReportGroupEditPage ReportGroupEditPage = new LoginPage()
                .checkCurrentPageUrlIsReportGroupEdit()
                .clickAvatar()
                .checkUserData();
    }
}
