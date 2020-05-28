package calendar;

import base.TestBase;
import org.junit.Test;
import pages.CalendarPage;
import pages.LoginPage;

public class CalendarTests extends TestBase {

    @Test
    public void checkCurrentMonth() {

        CalendarPage CalendarPage = new LoginPage()
                .openLoginPage()
                .fillUserNameField("Сергей Терентьев")
                .fillUserPasswordField("aHbtYp2508912")
                .catchAnException()
                .enterButtonClick()
                .openCalendarPage()
                .checkCurrentPageUrlIsCalendar();
    }
}