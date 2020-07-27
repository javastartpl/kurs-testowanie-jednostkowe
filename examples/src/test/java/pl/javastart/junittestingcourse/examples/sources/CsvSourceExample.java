package pl.javastart.junittestingcourse.examples.sources;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvSourceExample {

    @ParameterizedTest
    @CsvSource({"gmail.com, PROVIDER",
            "trash-mail.com, TRASHMAIL",
            "outlook.com, PROVIDER",
            "kowalski.pl, PRIVATE"})
    void shouldProperlyRecognizeEmailProvider(String domain, EmailProviderType expectedProviderType) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        EmailProviderType providerType = emailValidator.determineProviderType(domain);

        // then
        assertThat(providerType).isEqualTo(expectedProviderType);
    }

}
