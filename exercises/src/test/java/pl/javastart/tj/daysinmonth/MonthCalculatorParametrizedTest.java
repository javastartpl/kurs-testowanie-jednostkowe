package pl.javastart.tj.daysinmonth;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

class MonthCalculatorParametrizedTest {

    private MonthCalculator monthCalculator = new MonthCalculator();

    @ParameterizedTest
    @ValueSource(strings = { "2001-01", "2001-03", "2001-05", "2001-07", "2001-08", "2001-10", "2001-12"})
    public void shouldReturn31Days(String month) {
        // given
        YearMonth yearMonth = YearMonth.parse(month);

        // when
        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        // then
        assertThat(dayCount).isEqualTo(31);
    }

    @ParameterizedTest
    @CsvSource( {"2001, 04", "2001, 06", "2001, 09", "2001, 11" })
    public void shouldReturn30Days(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(30);
    }

    @ParameterizedTest
    @CsvSource( { "2021, 02"})
    public void shouldReturn28Days(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(28);
    }

    @ParameterizedTest
    @CsvSource( {"2004, 02", "2000, 02" })
    public void shouldReturn29Days(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(29);
    }

}