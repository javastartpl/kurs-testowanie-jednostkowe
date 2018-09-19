package pl.javastart.junittestingcourse.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class BehaviorTest {


    @BeforeEach
    public void init() {

        List<String> mock = Mockito.mock(List.class);

        Mockito.when(mock.get(1)).then(a -> "Ok");
        Mockito.when(mock.get(1)).thenReturn("a", "b");

        Mockito.when(mock.get(1)).getMock();

        Mockito.atLeastOnce();

    }

}
