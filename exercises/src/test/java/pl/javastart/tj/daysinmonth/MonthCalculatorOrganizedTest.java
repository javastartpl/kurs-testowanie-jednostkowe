package pl.javastart.tj.daysinmonth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MonthCalculatorOrganizedTest {

    private MonthCalculator monthCalculator;

    @BeforeEach
    public void init() {
        monthCalculator = new MonthCalculator();
    }

    @DisplayName("2018-06 -> 30")
    @Test
    public void shouldReturn30For2018_06() {
        // when
        int dayCount = monthCalculator.getDayCount(2018, 6);

        // then
        Assertions.assertEquals(30, dayCount);
    }

    @DisplayName("2018-07 -> 31")
    @Test
    public void shouldReturn31For2018_07() {
        // when
        int dayCount = monthCalculator.getDayCount(2018, 7);

        // then
        Assertions.assertEquals(31, dayCount);
    }

    @DisplayName("2018-08 -> 31")
    @Test
    public void shouldReturn31For2018_08() {
        // when
        int dayCount = monthCalculator.getDayCount(2018, 8);

        // then
        Assertions.assertEquals(31, dayCount);
    }

    @DisplayName("2018-02 -> 28")
    @Test
    public void shouldReturn28For2018_02() {
        // when
        int dayCount = monthCalculator.getDayCount(2018, 2);

        // then
        Assertions.assertEquals(28, dayCount);
    }

    @DisplayName("2016-02 -> 29")
    @Test
    public void shouldReturn29For2016_02() {
        // when
        int dayCount = monthCalculator.getDayCount(2016, 2);

        // then
        Assertions.assertEquals(29, dayCount);
    }

    @DisplayName("2010-02 -> 28")
    @Test
    public void shouldReturn28For2010_02() {
        // when
        int dayCount = monthCalculator.getDayCount(2010, 2);

        // then
        Assertions.assertEquals(28, dayCount);
    }

    @DisplayName("2010-02 -> 29")
    @Test
    public void shouldReturn29For2000_02() {
        // when
        int dayCount = monthCalculator.getDayCount(2000, 2);

        // then
        Assertions.assertEquals(29, dayCount);
    }

    @DisplayName("2100-02 -> 28")
    @Test
    public void shouldReturn28For2100_02() {
        // when
        int dayCount = monthCalculator.getDayCount(2100, 2);

        // then
        Assertions.assertEquals(28, dayCount);
    }

}