package pl.javastart.junittestingcourse.examples.sources;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumSourceExample {

    @ParameterizedTest
    @EnumSource(value = SignupStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "PAID")
    void shouldNotHaveAccess(SignupStatus signupStatus) {
        // given
        AccessController accessController = new AccessController();

        // when
        boolean hasAccess = accessController.checkAccessForSignupStatus(signupStatus);

        // then
        assertThat(hasAccess).isFalse();
    }

    @ParameterizedTest
    @EnumSource(value = SignupStatus.class, mode = EnumSource.Mode.MATCH_ALL, names = { ".*A.*", ".*ED" })
    void shouldNotHaveAccessMatching(SignupStatus signupStatus) {
        // given
        AccessController accessController = new AccessController();

        // when
        boolean hasAccess = accessController.checkAccessForSignupStatus(signupStatus);

        // then
        assertThat(hasAccess).isFalse();
    }

}
