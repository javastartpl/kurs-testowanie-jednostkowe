package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("fast")
public class CalculatorTest {

    @Test
    void shouldAdd1To1AndReturn2() {
        // given
        int a = 1;
        int b = 1;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertTrue(result == 2);
    }

    @Test
    void shouldAdd2To2AndReturn4() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(2, 2);

        // then
        Assertions.assertTrue(result == 2);
    }

    @Test
    void shouldAdd2To2AndReturn5() {

        assumeTrue(false);

        // given
        int a = 2;
        int b = 2;
        Calculator calculator = new Calculator();

        // when
        final int result = calculator.add(a, b);

        // then
//        Assertions.assertEquals(5, result);
//        Assertions.assertAll(() -> {});

        Assertions.assertAll(
                () -> org.assertj.core.api.Assertions.assertThat(result).isEqualTo(5),
                () -> org.assertj.core.api.Assertions.assertThat(result).isEqualTo(6)
        );
    }



}