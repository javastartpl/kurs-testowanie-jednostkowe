package pl.javastart.junittestingcourse.junit4;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void shouldReturn2For1And1() {
        // given
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 1;

        // when
        int result = calculator.add(1, 1);

        // then
        Assert.assertTrue(result == 1);
    }

}