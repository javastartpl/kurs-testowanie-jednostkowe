package pl.javastart.junittestingcourse.examples.sources;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvFileSourceExample {

    @ParameterizedTest
    @CsvFileSource(resources = "email-data.csv", numLinesToSkip = 1)
    void shouldProperlyRecognizeEmailProvider(String domain, EmailProviderType expectedProviderType) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        EmailProviderType providerType = emailValidator.determineProviderType(domain);

        // then
        assertThat(providerType).isEqualTo(expectedProviderType);
    }

}
