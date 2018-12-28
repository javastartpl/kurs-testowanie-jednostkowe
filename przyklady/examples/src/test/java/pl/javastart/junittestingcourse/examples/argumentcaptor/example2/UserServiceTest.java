package pl.javastart.junittestingcourse.examples.argumentcaptor.example2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    @Mock UserRepository userRepository;
    @InjectMocks UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldAdd2Users() {
        // given
        List<UserDto> users = Arrays.asList(new UserDto("Anna", "Abacka"), new UserDto("Karol", "Koralewski"));

        // when
        userService.createMultipleUsers(users);
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> surnameCaptor = ArgumentCaptor.forClass(String.class);

        // then
        Mockito.verify(userRepository, Mockito.times(2)).addUser(nameCaptor.capture(), surnameCaptor.capture());

        String name1 = nameCaptor.getAllValues().get(0);
        String surname1 = surnameCaptor.getAllValues().get(0);
        String name2 = nameCaptor.getAllValues().get(1);
        String surname2 = surnameCaptor.getAllValues().get(1);

        assertThat(name1).isEqualTo("Anna");
        assertThat(surname1).isEqualTo("Abacka");
        assertThat(name2).isEqualTo("Karol");
        assertThat(surname2).isEqualTo("Koralewski");
    }

    @Test
    void shouldAdd2UsersWithoutCaptors() {
        // given
        List<UserDto> users = Arrays.asList(new UserDto("Anna", "Abacka"), new UserDto("Karol", "Koralewski"));

        // when
        userService.createMultipleUsers(users);

        // then
        Mockito.verify(userRepository, Mockito.times(1)).addUser("Anna", "Abacka");
        Mockito.verify(userRepository, Mockito.times(1)).addUser("Karol", "Koralewski");
    }

    @Test
    void shouldAdd2UsersWithNulls() {
        // given
        List<UserDto> users = Arrays.asList(new UserDto("Anna", null), new UserDto("Karol", null));

        // when
        userService.createMultipleUsers(users);
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);

        // then
        Mockito.verify(userRepository, Mockito.times(2)).addUser(nameCaptor.capture(), ArgumentMatchers.any());
        // lub
        Mockito.verify(userRepository, Mockito.times(2)).addUser(nameCaptor.capture(), ArgumentMatchers.isNull());

        String name1 = nameCaptor.getAllValues().get(0);
        String name2 = nameCaptor.getAllValues().get(1);

        assertThat(name1).isEqualTo("Anna");
        assertThat(name2).isEqualTo("Karol");
    }

}