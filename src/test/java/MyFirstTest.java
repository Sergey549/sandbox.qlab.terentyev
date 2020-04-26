import org.junit.jupiter.api.*;

public class MyFirstTest {

    @BeforeAll
    static void beforeAllTests() {
        textTyping("MyFirstTest class started");
    }

    @BeforeEach
    public void beforeEachTest() {
        textTyping("Test start");
    }


    @Test
    public void myTest() {
        textTyping("My first autotest running");
    }

    @Test
    public void test1() {
        textTyping("Test №1");
    }

    @Test
    public void test2() {
        textTyping("Test №2");
    }

    @Test
    public void test3() {
        textTyping("Test №3");
    }

    @Test
    public void test4() {
        textTyping("Test №4");
    }

    @Test
    public void test5() {
        textTyping("Test №5");
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
        textTyping("MyFirstTest class finished");
    }

}
