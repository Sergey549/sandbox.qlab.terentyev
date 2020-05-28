package autotests;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertAll;


public class MyFirstTest {


    @BeforeAll
    static void beforeAllTests()
    {

        System.out.println("autotests.MyFirstTest class started");
    }

    @BeforeEach
    public void beforeEachTest()
    {

        System.out.println("Test start");
    }


    @Test
    public void myTest() {
        System.out.println("My first autotest running");
        Assert.assertEquals(1/0,1);
    }

    @Test
    public void test1() {
        System.out.println("Test №1");
        Assert.assertEquals (2+2 ,4);
    }

    @Test
    public void test2() {
        System.out.println("Test №2");
        Assert.assertEquals(2+2, 5);
    }

    @Test
    public void test3() {
        System.out.println("Test №3");
        Assert.assertTrue(2+2 == 4);

    }

    @Test
    public void test4() {
        System.out.println("Test №4");
        Assert.assertTrue(2+2 == 5);
    }

    @Test
    public void tets5() {
        System.out.println("Test №5");

        assertAll("TestsAssertions",
                () -> Assert.assertEquals(2 + 2, 4),
                () -> Assert.assertEquals(2 + 2, 5),
                () -> Assert.assertTrue(2 + 2 == 4),
                () -> Assert.assertTrue(2 + 2 == 5)
        );
    }

    @AfterEach
    public void afterEachTests() {
        System.out.println("Test finished");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("autotests.MyFirstTest class finished");
    }

}
