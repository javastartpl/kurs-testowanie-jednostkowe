package pl.javastart.junittestingcourse.examples.mockitoverify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MockitoVerifyExample {

    @Test
    void verifyExample() {
        MyClass mock = Mockito.mock(MyClass.class);

        mock.myMethod();

        verify(mock, atLeastOnce()).myMethod();
    }

}
