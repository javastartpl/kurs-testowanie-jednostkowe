package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("slow")
@DisplayName("Writing assertions for lists")
class ListAssertionTest {
 
    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements {
 
        private Object first;
        private Object second;
 
        private List<Object> list;
 
        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();
 
            list = Arrays.asList(first, second);
        }
 
        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list).containsExactly(first, second);
        }
    }
}