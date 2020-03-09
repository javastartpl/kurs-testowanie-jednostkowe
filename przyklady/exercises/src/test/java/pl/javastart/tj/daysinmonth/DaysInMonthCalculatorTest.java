package pl.javastart.tj.daysinmonth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javastart.tj.daysinmonth.DaysInMonthCalculator;

import static org.assertj.core.api.Assertions.assertThat;

class DaysInMonthCalculatorTest {

    @Test
    void shouldReturn30_for_2018_06() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2018, 06);

        // then
        assertThat(count).isEqualTo(30);
    }

    @Test
    void shouldReturn31_for_2018_07() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2018, 7);

        // then
        assertThat(count).isEqualTo(31);
    }

    @Test
    void shouldReturn31_for_2018_08() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2018, 8);

        // then
        assertThat(count).isEqualTo(31);
    }

    @Test
    void shouldReturn28_for_2018_02() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2018, 2);

        // then
        assertThat(count).isEqualTo(28);
    }


    @Test
    void shouldReturn29_for_2016_02() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2016, 2);

        // then
        assertThat(count).isEqualTo(29);
    }

    @Test
    void shouldReturn28_for_2010_02() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2010, 2);

        // then
        assertThat(count).isEqualTo(28);
    }


    @DisplayName("28 for 2000-02")
    @Test
    void shouldReturn28_for_2000_02() {
        // given
        DaysInMonthCalculator dayInMonthCounter = new DaysInMonthCalculator();

        // when
        int count = dayInMonthCounter.geDayCount(2010, 2);

        // then
        assertThat(count).isEqualTo(28);
    }

}