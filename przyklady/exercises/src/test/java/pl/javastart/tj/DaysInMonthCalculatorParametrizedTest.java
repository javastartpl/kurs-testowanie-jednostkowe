package pl.javastart.tj;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DaysInMonthCalculatorParametrizedTest {

    private DaysInMonthCalculator daysInMonthCalculator = new DaysInMonthCalculator();

    @ParameterizedTest
    @CsvSource({"2018, 05", "2018, 07", "2018, 08", "2016, 05" , "2014, 05", "2011, 05"})
    void shouldReturn31(int year, int month) {
        // when
        int count = daysInMonthCalculator.geDayCount(year, month);

        // then
        assertThat(count).isEqualTo(31);
    }

    @ParameterizedTest
    @CsvSource({"2018, 6"})
    void shouldReturn30(int year, int month) {
        // when
        int count = daysInMonthCalculator.geDayCount(year, month);

        // then
        assertThat(count).isEqualTo(30);
    }

    @ParameterizedTest
    @CsvSource({"2018, 02", "2010, 02", "2000, 02"})
    void shouldReturn28(int year, int month) {
        // when
        int count = daysInMonthCalculator.geDayCount(year, month);

        // then
        assertThat(count).isEqualTo(28);
    }

    @ParameterizedTest
    @CsvSource({"2016, 02"})
    void shouldReturn29(int year, int month) {
        // when
        int count = daysInMonthCalculator.geDayCount(year, month);

        // then
        assertThat(count).isEqualTo(29);
    }

}