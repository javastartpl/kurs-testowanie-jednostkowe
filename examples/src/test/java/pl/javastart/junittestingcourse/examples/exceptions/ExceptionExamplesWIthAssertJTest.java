package pl.javastart.junittestingcourse.examples.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ExceptionExamplesWIthAssertJTest {

    private void divideByZero() {
        int notAGreatIdea = 5 / 0;
    }

    private void divideByOne() {
        int notAGreatIdea = 5 / 1;
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJ() {
        Assertions.assertThatThrownBy(this::divideByZero) // org.assertj.core.api.Assertions
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJFail() {
        Assertions.assertThatThrownBy(() -> divideByOne()) // org.assertj.core.api.Assertions
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");

        /*
            Inne przykładowe asercje
            .hasMessage("")
            .hasMessageStartingWith("/ by")
            .hasMessageContaining("zero")
            .hasCauseInstanceOf(ArithmeticException.class)
            .hasStackTraceContaining("ArithmeticException");
         */
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJLessFluent() {
        // org.assertj.core.api.Assertions
        ArithmeticException at = Assertions.catchThrowableOfType(() -> divideByZero(), ArithmeticException.class);
        Throwable t = Assertions.catchThrowable(() -> divideByZero());

        Assertions.assertThat(t)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    @Test
    public void shouldThrow() {
        Assertions.shouldHaveThrown(FileNotFoundException.class);
        Assertions.failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

}
