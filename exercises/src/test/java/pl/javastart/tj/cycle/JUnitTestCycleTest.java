package pl.javastart.tj.cycle;

import org.junit.jupiter.api.*;


public class JUnitTestCycleTest {

    private int counter = 0;

    @Test
    public void test1() {
        counter++;
        System.out.println("test1 " + counter);
    }

    @Test
    public void test2() {
        counter++;
        System.out.println("test2 " + counter);
    }

    @Test
    public void test3() {
        counter++;
        System.out.println("test2 " + counter);
    }

}
