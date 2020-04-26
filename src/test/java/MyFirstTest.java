import org.junit.jupiter.api.*;

public class MyFirstTest {

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("MyFirstTest class started");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Test start");
    }

    @Test
    public void myTest() {
        System.out.println("My first autotest running");
    }

    @Test
    public void test1() {
        System.out.println("Test №1");
    }


    @Test
    public void test2() {
        System.out.println("Test №2");
    }

    @Test
    public void test3() {
        System.out.println("Test №3");
    }

    @Test
    public void test4() {
        System.out.println("Test №4");
    }

    @Test
    public void test5() {
        System.out.println("Test №5");
    }


    @AfterEach
    public void afterEachTests() {
        System.out.println("Test finished");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("MyFirstTest class finished");
    }

}
