package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLifecycle {

    private int licznik = 0;

    @BeforeAll
    public static void initAll() {
        System.out.println("Wykonuje BeforeAll");
    }

    @BeforeEach
    public void init() {
        System.out.println("Wykonuje BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("Wykonuje test 1. Licznik to: " + licznik);
        licznik = 1;
    }

    @Test
    public void test2() {
        System.out.println("Wykonuje test 2. Licznik to: " + licznik);
        licznik = 2;
    }

    @Test
    public void test3() {
        System.out.println("Wykonuje test 3. Licznik to: " + licznik);
        licznik = 3;
    }

    @AfterEach
    public void after() {
        System.out.println("Wykonuje AfterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Wykonuje AfterAll");
    }
}
