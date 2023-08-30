package pl.javastart.junittestingcourse.examples.mockito.strict;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.junittestingcourse.examples.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StrictStubbingExample {

//    @Mock(strictness = Mock.Strictness.LENIENT) Service serviceMock;

    @Test
    public void shouldWorkJustFine() {
        // given
        Service serviceMock = Mockito.mock(Service.class);
        Mockito.when(serviceMock.doSomething("a")).thenReturn("1");
        Mockito.when(serviceMock.doSomething("b")).thenReturn("2"); // nigdy nie używane

        // when
        String result = serviceMock.doSomething("a");

        // then
        assertEquals(result, "1");
    }

//    @Test
//    public void shouldWorkJustFine() throws Exception {
//        MockitoSession mockitoSession = Mockito.mockitoSession()
//                .strictness(Strictness.STRICT_STUBS)
//                .startMocking();
//
//        // given
//        Service serviceMock = Mockito.mock(Service.class);
//
//        Mockito.when(serviceMock.doSomething("a")).thenReturn("1");
//        Mockito.lenient().when(serviceMock.doSomething("b")).thenReturn("2"); // nigdy nie używane
//
//        // when
//        String result = serviceMock.doSomething("a");
//
//        // then
//        assertEquals(result, "1");
//        mockitoSession.finishMocking();
//    }

}
