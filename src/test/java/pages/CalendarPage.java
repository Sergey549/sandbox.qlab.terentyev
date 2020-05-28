package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class CalendarPage {

    public CalendarPage checkCurrentPageUrlIsCalendar() {
        driver().getCurrentFrameUrl();
        String URL = driver().getCurrentFrameUrl();
        Assert.assertEquals(URL,"https://tt-develop.quality-lab.ru/calendar/");
    return this;
    }

    public CalendarPage waitForPreloader() {
    $(new By.ByCssSelector("span.btn")).exists();
        return this;
    }

    public CalendarPage checkYearAndMonth() {
        Calendar calendar = Calendar.getInstance();
        String[] monthNames = { "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь" };
        String month = monthNames[calendar.get(Calendar.MONTH)];
        LocalDate date = LocalDate.now();
        String currentDate = date.format(DateTimeFormatter.ofPattern(month + " yyyy"));
        SelenideElement calendarDate = $(new By.ByCssSelector("span[id = 'schedule-month-title']"));
        Assert.assertEquals(currentDate, calendarDate.getText());
        return this;
    }

    public CalendarPage monthDropdownClick() {
        $(new By.ByCssSelector("input[name='filter-date']"));
    return this;
    }

    public CalendarPage chooseNewMonth() {
        return this;
    }

    public CalendarPage applyChanges() {
        return this;
    }

    public CalendarPage chooseAnotherColleague() {
        $(new By.ByCssSelector("span[id='select2--container']"));
        return this;
    }

    public CalendarPage fillSearchForm() {
    return this;
    }
}
