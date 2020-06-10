package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticImportExample {

    @Test
    void shouldAdd2To2AndReturn4() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(2, 2);

        // then
        assertEquals(2, result);
        assertTrue(result == 2);
    }
}
