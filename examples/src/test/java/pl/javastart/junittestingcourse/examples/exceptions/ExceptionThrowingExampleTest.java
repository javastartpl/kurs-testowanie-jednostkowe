package pl.javastart.junittestingcourse.examples.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ExceptionThrowingExampleTest {

    @Test
    public void shouldThrowNoAccessException() {
        UserManager userManager = Mockito.mock(UserManager.class);

        when(userManager.findById(ArgumentMatchers.anyLong())).thenThrow(new NoAccessException());

        // to samo co wyżej, przydatne w przypadku gdyby metoda findById zwracała void
//        doThrow(new NoAccessException()).when(userManager).findById(1L);

        Assertions.assertThatThrownBy(() -> userManager.findById(1L))
                .isInstanceOf(NoAccessException.class);
    }

    private interface UserManager {
        User findById(Long id);
    }

    private interface User { }
    private static class NoAccessException extends RuntimeException { }
}
