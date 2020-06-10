package pl.javastart.tj.junit5assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnit5AssertionsSolutionTest {

    @Test
    public void should7BePrimeNumber() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        boolean result = sut.isPrimeNumber(7);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void should1BePrimeNumber() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        boolean result = sut.isPrimeNumber(1);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    public void should9NotBePrimeNumber() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        boolean result = sut.isPrimeNumber(9);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    public void should10NotBePrimeNumber() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        boolean result = sut.isPrimeNumber(10);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnSameObjects() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        JUnit5AssertionsSolution.Code firstCode = sut.getCode("a");
        JUnit5AssertionsSolution.Code secondCode = sut.getCode("a");

        // then
        Assertions.assertSame(firstCode, secondCode);
    }

    @Test
    public void shouldReturnDifferentObjects() {
        // given
        JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

        // when
        JUnit5AssertionsSolution.Code firstCode = sut.getCode("a");
        JUnit5AssertionsSolution.Code secondCode = sut.getCode("b");

        // then
        Assertions.assertNotSame(firstCode, secondCode);
    }

}
