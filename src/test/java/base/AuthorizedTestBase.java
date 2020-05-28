package base;

import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;

public class AuthorizedTestBase {

    TestData positiveData = new TestData("Сергей Терентьев", "RVwj1waJ2Hf");

    @BeforeEach
    public void Authorization() {
        new LoginPage()
                .openLoginPage()
                .fillUserNameField(positiveData.userName)
                .fillUserPasswordField(positiveData.userPassword)
                .catchAnException()
                .enterButtonClick();
    }
}
