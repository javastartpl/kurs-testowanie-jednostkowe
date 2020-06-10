package pl.javastart.junittestingcourse.examples.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {


    @Test
    public void shouldThrowException() {

        Assertions.assertThatThrownBy();

        Assertions.shouldHaveThrown()

    }

}
