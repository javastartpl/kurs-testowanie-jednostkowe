package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {

    @Test void shouldBeValid() {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        boolean isValid = emailValidator.isValid("example@example.com");

        // then
        assertThat(isValid).isEqualTo(true);

    }

@ParameterizedTest
@ValueSource(strings = {"example@example.com", "a@a.pl", "a@domena.com.pl", "a123@onion"})
void shouldBeValidEmail(String email) {
    // given
    EmailValidator emailValidator = new EmailValidator();

    // when
    boolean isValid = emailValidator.isValid(email);

    // then
    assertThat(isValid).isEqualTo(true);
}

}
