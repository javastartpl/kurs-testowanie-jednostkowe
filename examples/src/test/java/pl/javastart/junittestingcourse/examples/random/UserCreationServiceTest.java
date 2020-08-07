package pl.javastart.junittestingcourse.examples.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserCreationServiceTest {

    @Mock DateTimeProvider dateTimeProvider;

    private UserCreationService userCreationService;
    private ZonedDateTime now;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        userCreationService = new UserCreationService(dateTimeProvider);

        now = ZonedDateTime.now();
        when(dateTimeProvider.nowAsZonedDateTime()).thenReturn(now);
    }

    @Test
    void shouldCreateUserWithValidName() {
        // when
        User user = userCreationService.createUser("Ania");

        // then
        assertThat(user.getName()).isEqualTo("Ania");
    }

    @Test
    void shouldCreateUserWithNonNullCreationDate() {
        // when
        User user = userCreationService.createUser("");

        // then
        assertThat(user.getCreationDate()).isNotNull();
    }

    @Test
    void shouldCreateUserWithCurrentCreationDate() {
        // when
        User user = userCreationService.createUser("");

        // then
        assertThat(user.getCreationDate()).isEqualTo(now);
    }


}