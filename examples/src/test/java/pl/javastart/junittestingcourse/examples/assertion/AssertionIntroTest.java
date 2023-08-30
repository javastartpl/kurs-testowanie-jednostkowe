package pl.javastart.junittestingcourse.examples.assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class AssertionIntroTest {

    @Test
    void shouldAdd1To1AndReturn2() {
        // given
        int a = 1;
        int b = 1;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldAdd2To2AndReturn5() {
        // given
        int a = 2;
        int b = 2;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertTrue(result == 5);
    }

}
