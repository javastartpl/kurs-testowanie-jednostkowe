package pl.javastart.junittestingcourse.examples.mockito.behaviour;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;

public class BehaviorTest {

    @Test
    public void shouldAlwaysReturnGivenName() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).thenReturn("Kasia");

        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");
    }


















    @Test
    public void testMockitoWhenValues() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).thenReturn("Kasia", "Basia", "Krysia", "Tomek");

        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Basia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Tomek");
        assertThat(user.getName()).isEqualTo("Tomek");
    }



    @Test
    public void shouldAlwaysReturnGivenNameLazyWay() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).then(i -> {
            System.out.println("Liczenie wartości wynikowej");
            return "Kasia";
        });

        System.out.println("Zaraz będę sprawdzał po raz #1");
        assertThat(user.getName()).isEqualTo("Kasia");
        System.out.println("Zaraz będę sprawdzał po raz #2");
        assertThat(user.getName()).isEqualTo("Kasia");
        System.out.println("Zaraz będę sprawdzał po raz #3");
        assertThat(user.getName()).isEqualTo("Kasia");
    }

    @Test
    public void shouldThrowExceptionOnGetter() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).thenThrow(new IllegalStateException());

        assertThat(user.getName());
    }


    @Test
    public void shouldThrowExceptionOnSetter() {
        User user = Mockito.mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName("Kasia");

        user.setName("Basia");
        user.setName("Kasia");
    }



}
