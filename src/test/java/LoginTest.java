import org.junit.Test;
import org.openqa.selenium.Dimension;

public class LoginTest extends TestBase {

    @Test
    public void TestCase() {
        //Меняем заданный при инициализации размер окна
        driver.manage().window().setSize(new Dimension(210, 100));
        driver.get("https://tt-develop.quality-lab.ru/login");
    }

}