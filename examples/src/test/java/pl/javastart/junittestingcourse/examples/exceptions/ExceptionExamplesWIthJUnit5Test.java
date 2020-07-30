package pl.javastart.junittestingcourse.examples.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionExamplesWIthJUnit5Test {

    private void divideByZero() {
        int notAGreatIdea = 5 / 0;
    }

    @Test
    public void shouldFailBecauseOfAnException() {
        // wynik: java.lang.ArithmeticException
        divideByZero();
    }









    @Test
    public void shouldFailBecauseOfAnExceptionWithExpliciteTesting() {
        // wynik: org.opentest4j.AssertionFailedError: Unexpected exception thrown: java.lang.ArithmeticException
        Assertions.assertDoesNotThrow(() -> divideByZero());
    }











    @Test
    public void shouldVerifyThatExceptionIsThrownWithoutFramework() {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            assertThat(e.getMessage()).isEqualTo("/ by zero");
            return;
        }
        Assertions.fail("Expected exception was not thrown!");
    }





    @Test
    public void shouldThrowException() {
        Throwable thrownException = Assertions.assertThrows(ArithmeticException.class, this::divideByZero);
        assertThat(thrownException).extracting(Throwable::getMessage).isEqualTo("/ by zero");
    }







    @Test
    public void shouldVerifyThatExceptionIsThrownWithJUnit5() {
        ArithmeticException e = Assertions.assertThrows(ArithmeticException.class, () -> divideByZero());
        assertThat(e.getMessage()).isEqualTo("/ by zero");
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJ() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> divideByZero())
                .hasMessage("/ by zero");
    }

}
