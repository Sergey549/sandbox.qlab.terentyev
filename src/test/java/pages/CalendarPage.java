package pages;

import org.junit.Assert;

import static com.codeborne.selenide.WebDriverRunner.driver;

public class CalendarPage {


    public CalendarPage checkCurrentPageUrlIsCalendar() {
        driver().getCurrentFrameUrl();
        String URL = driver().getCurrentFrameUrl();
        Assert.assertEquals(URL,"https://tt-develop.quality-lab.ru/calendar/");
    return this;
    }
}
