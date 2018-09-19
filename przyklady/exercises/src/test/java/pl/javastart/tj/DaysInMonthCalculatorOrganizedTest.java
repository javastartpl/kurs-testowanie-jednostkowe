package pl.javastart.tj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DaysInMonthCalculatorOrganizedTest {
    
    private DaysInMonthCalculator daysInMonthCalculator;
    
    @BeforeEach
    void init() {
        daysInMonthCalculator = new DaysInMonthCalculator();
    }

    @DisplayName("30 for 2018-06")
    @Test
    void shouldReturn30_for_2018_06() {
        // when
        int count = daysInMonthCalculator.geDayCount(2018, 06);

        // then
        assertThat(count).isEqualTo(30);
    }

    @DisplayName("31 for 2018-07")
    @Test
    void shouldReturn31_for_2018_07() {
        // when
        int count = daysInMonthCalculator.geDayCount(2018, 7);

        // then
        assertThat(count).isEqualTo(31);
    }

    @DisplayName("31 for 2018-08")
    @Test
    void shouldReturn31_for_2018_08() {
        // when
        int count = daysInMonthCalculator.geDayCount(2018, 8);

        // then
        assertThat(count).isEqualTo(31);
    }

    @DisplayName("28 for 2018-02")
    @Test
    void shouldReturn28_for_2018_02() {
        // when
        int count = daysInMonthCalculator.geDayCount(2018, 2);

        // then
        assertThat(count).isEqualTo(28);
    }

    @DisplayName("29 for 2016-02")
    @Test
    void shouldReturn29_for_2016_02() {
        // when
        int count = daysInMonthCalculator.geDayCount(2016, 2);

        // then
        assertThat(count).isEqualTo(29);
    }

    @DisplayName("28 for 2010-02")
    @Test
    void shouldReturn28_for_2010_02() {
        // when
        int count = daysInMonthCalculator.geDayCount(2010, 2);

        // then
        assertThat(count).isEqualTo(28);
    }

    @DisplayName("28 for 2000-02")
    @Test
    void shouldReturn28_for_2000_02() {
        // when
        int count = daysInMonthCalculator.geDayCount(2000, 2);

        // then
        assertThat(count).isEqualTo(28);
    }

}