package pages;

import login.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ReportGroupEditPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span/div/div")
    private WebElement avatarIcon;

    @FindBy(css = "span.m-card-user__name")
    private WebElement secondName;

    @FindBy(css = "span.m-card-user__email")
    private WebElement email;

    public ReportGroupEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ReportGroupEditPage clickAvatar() {
        avatarIcon.click();
        return this;
    }

    public ReportGroupEditPage checkUserData() {
        TestData data = new TestData();
        secondName.getText().contains("Терентьев Сергей");
        Assert.assertEquals(email.getText(),data.userEmail);
        return this;
    }
}
