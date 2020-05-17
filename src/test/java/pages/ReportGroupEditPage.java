package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportGroupEditPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span/div/div")
    private WebElement avatarImput;

    @FindBy(css = "span.m-card-user__name")
    private WebElement secondName;

    @FindBy(css = "span.m-card-user__email")
    private WebElement email;

    public ReportGroupEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ReportGroupEditPage clickAvatar() {
        avatarImput.click();
        return this;
    }

    public ReportGroupEditPage checkSecondUserName() {
        String s1 = secondName.getText();
        System.out.println("The User Mane is: " + s1);
        Assert.assertEquals(s1, "Терентьев Сергей Константинович");
        return this;
    }

    public ReportGroupEditPage checkUserEmail() {
        String s2 = email.getText();
        System.out.println("The User Email is: " + s2);
        Assert.assertEquals(s2, "fake+329@quality-lab.ru");
        return this;
    }
}
