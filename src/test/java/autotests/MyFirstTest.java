package autotests;

import com.codeborne.selenide.junit.SoftAsserts;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertAll;


public class MyFirstTest {


    @BeforeAll
    static void beforeAllTests() {
        textTyping("autotests.MyFirstTest class started");
    }

    @BeforeEach
    public void beforeEachTest() {
        textTyping("Test start");
    }


    @Test
    public void myTest() {
        textTyping("My first autotest running");
        Assert.assertTrue(1/0 == 1);
    }

    @Test
    public void test1() {
        textTyping("Test №1");
        Assert.assertTrue(2+2 == 4);
    }

    @Test
    public void test2() {
        textTyping("Test №2");
        Assert.assertEquals(2+2, 5);
    }

    @Test
    public void test3() {
        textTyping("Test №3");
        Assert.assertTrue(2+2 == 4);

    }

    @Test
    public void test4() {
        textTyping("Test №4");
        Assert.assertEquals(2+2, 5);
    }

    @Test
    public void test5() {
        SoftAsserts softy = new SoftAsserts();
        textTyping("Test №5");
        Assert.assertTrue(2+2 == 4);
        Assert.assertEquals(2+2,5);
        Assert.assertTrue(2+2 == 4);
        Assert.assertEquals(2+2, 5);
        assertAll();
    }

    private static void textTyping(String s) {
        System.out.println(s);
    }

    @AfterEach
    public void afterEachTests() {
        textTyping("Test finished");
    }

    @AfterAll
    static void afterAllTests() {
        textTyping("autotests.MyFirstTest class finished");
    }

}
