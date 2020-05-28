package calendar;

import base.AuthorizedTestBase;
import base.TestBase;
import org.junit.jupiter.api.*;
import pages.CalendarPage;
import pages.LoginPage;

public class CalendarTests extends TestBase {

    AuthorizedTestBase authorization = new AuthorizedTestBase();

    @BeforeEach
    public void preconditions() {
        authorization.Authorization();
        CalendarPage CalendarPage = new LoginPage()
                .openCalendarPage()
                .checkCurrentPageUrlIsCalendar()
                .waitForPreloader();
    }

    @Test
    public void calendarYearAndMonthEqualsCurrent() {
        new CalendarPage()
                .checkYearAndMonth();
    }
    @Test
    public void monthSwitch() {
        new CalendarPage()
                .monthDropdownClick()
                .chooseNewMonth()
                .applyChanges();
    }
    @Test
    public void checkColleagueCalender() {
        new CalendarPage()
                .chooseAnotherColleague()
                .fillSearchForm()
                .applyChanges()
                .waitForPreloader();
    }
}

