package pl.javastart.junittestingcourse.examples.mockito.behaviour.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArgumentMatcherTest {

    @Test
    public void shouldHandleVoidMethod() {
        User user = mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName(ArgumentMatchers.any());

        user.setName("Basia");
        user.setName("Kasia");
    }

    @Test
    public void simpleTypeMatchers() {
        ArgumentMatchers.anyString();
        ArgumentMatchers.anyByte();
        ArgumentMatchers.anyShort();
        ArgumentMatchers.anyInt();
        ArgumentMatchers.anyLong();
        ArgumentMatchers.anyFloat();
        ArgumentMatchers.anyDouble();
        ArgumentMatchers.anyChar();
        ArgumentMatchers.anyString();
    }

    @Test
    public void collectionsMatchers() {
        ArgumentMatchers.anySet();
        ArgumentMatchers.anyList();
        ArgumentMatchers.anyMap();
        ArgumentMatchers.anyCollection();
        ArgumentMatchers.anyIterable();
    }

    @Test
    public void eqMatchers() {
        String text = "";

        ArgumentMatchers.eq("");
        ArgumentMatchers.refEq(text);
    }

    @Test
    public void stringMatchers() {
        ArgumentMatchers.contains("string part");
        ArgumentMatchers.startsWith("string start");
        ArgumentMatchers.endsWith("string end");
        ArgumentMatchers.matches("regex");
    }

    @Test
    public void conditionMatchers() {
        ArgumentMatchers.intThat(value -> value > 2);
        ArgumentMatchers.longThat(value -> value < 100);
        ArgumentMatchers.booleanThat(value -> !value);
    }

    @Test
    public void shouldCheckIfAdult() {
        AdultChecker adultChecker = mock(AdultChecker.class);
        when(adultChecker.checkIfAdult(intThat(age -> age < 18))).thenReturn(false);
        when(adultChecker.checkIfAdult(intThat(age -> age >= 18))).thenReturn(true);

        assertThat(adultChecker.checkIfAdult(5)).isFalse();
        assertThat(adultChecker.checkIfAdult(30)).isTrue();
    }

    @Test
    public void customMatcher() {
        File file = new File("file.txt");
        File fileMatcher = ArgumentMatchers.argThat((ArgumentMatcher<File>) argument -> file.getName().endsWith(".txt"));

        ArgumentMatchers.argThat(new ArgumentMatcher<File>() {
            @Override
            public boolean matches(File argument) {
                return argument.getName().endsWith(".txt");
            }
        });
    }

    @Test
    public void nullMatchers() {
        ArgumentMatchers.notNull(); // to samo co ArgumentMatchers.isNotNull()
        ArgumentMatchers.isNotNull(); // to samo co ArgumentMatchers.notNull()
        ArgumentMatchers.isNull();
        ArgumentMatchers.nullable(Clazz.class); // null or type
    }

    @Test
    public void anyMatchers() {
        ArgumentMatchers.any();
        ArgumentMatchers.any(String.class);
    }

    static class Clazz {

    }
}
