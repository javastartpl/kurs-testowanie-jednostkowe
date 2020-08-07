package pl.javastart.tj.random;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PasswordResetGenerationServiceTest {

    @Test
    public void shouldReturnPasswordResetMessage() {
        // given
        RandomTextGenerator randomTextGenerator = Mockito.mock(RandomTextGenerator.class);
        when(randomTextGenerator.getRandomText()).thenReturn("f32mr1rm892ng92r12");

        PasswordResetGenerationService service = new PasswordResetGenerationService(randomTextGenerator);

        // when
        String message = service.preparePasswordResetMessage();

        // then
        assertThat(message).isEqualTo("Cześć, aby przejść do resetowania hasła naciśnij " +
                "<a href=\"https://example.com/reset?key=f32mr1rm892ng92r12\">ten link</a>");
    }

}