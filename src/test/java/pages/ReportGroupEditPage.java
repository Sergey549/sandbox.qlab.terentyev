package pages;

import com.codeborne.selenide.SelenideElement;
import base.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ReportGroupEditPage {

    private SelenideElement avatar= $(new By.ByXPath("//span/div/div"));
    private SelenideElement name = $(new By.ByCssSelector("span.m-card-user__name"));
    private SelenideElement email = $(new By.ByCssSelector("span.m-card-user__email"));

    public ReportGroupEditPage clickAvatar() {
        avatar.click();
        return this;
    }

    public ReportGroupEditPage checkUserData() {
        TestData data = new TestData("Сергей Терентьев", null);
        //System.out.println(data.userName);
        //System.out.println(name.getText());
        name.getText().contains(data.userName);
        Assert.assertEquals(email.getText(), data.userEmail);
        return this;
    }

}